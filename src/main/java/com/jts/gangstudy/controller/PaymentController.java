package com.jts.gangstudy.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jts.gangstudy.domain.Booking;
import com.jts.gangstudy.domain.Payment;
import com.jts.gangstudy.domain.User;
import com.jts.gangstudy.service.BookingService;
import com.jts.gangstudy.service.KakaoPayService;
import com.jts.gangstudy.service.PaymentService;
import com.jts.gangstudy.service.UserService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private UserService userService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private KakaoPayService kakaoPayService;

	// 결제 수단 선택
	@RequestMapping(value = "/choose", method = RequestMethod.GET)
	public ModelAndView choose(HttpServletRequest request) {
		// 여러 결제 수단이 있을때 브릿지 역할
		ModelAndView mav = new ModelAndView("/payment/choose");
		return mav;
	}

	// KakaoPay를 통한 결제 요청
	@RequestMapping(value = "/kakaopay", method = RequestMethod.GET)
	public String kakaopay(HttpServletRequest request, HttpSession session) {
		int amount = (int)session.getAttribute("amount");			// 결제 비용
		int usePoint = (int)session.getAttribute("usePoint");		// 사용한 포인트
		String deviceType = paymentService.getDeviceType(request);	// 결제 요청 장비
		String domain = request.getScheme()+"://"+request.getServerName() + ":" +request.getServerPort(); // 요청 도메인
		
		System.out.println(domain);
		HashMap<String, String> map = kakaoPayService.ready(domain, deviceType, amount-usePoint);
		
		session.setAttribute("tid", map.get("tid"));
		return "redirect:" + map.get("url");
	}

	// KakaoPay에서 결제 준비됨. 결제 처리하기
	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String complete(HttpServletRequest request, HttpSession session) {
		User user = (User)session.getAttribute("sUserId");
		Booking book = (Booking)session.getAttribute("book");
		String tid = (String)session.getAttribute("tid");
		int amount = (int)session.getAttribute("amount");
		int usePoint = (int)session.getAttribute("usePoint");

		String pg_token = request.getParameter("pg_token");
		
		// 결제 완료 요청
		HashMap<String, String> payInfo = kakaoPayService.getPayInfo(tid, pg_token);

		// 결제 정보를 저장한다.
		Payment payment = new Payment();
		payment.setAmount(amount-usePoint);
		payment.setPoint(usePoint);
		payment.setPg_name("KakaoPay");
		payment.setTid(tid);
		payment.setPay_type(payInfo.get("pay_type"));
		payment.setState("paid");
		payment.setBook_no(book.getBook_no());
		paymentService.insertPayment(payment);
		
		userService.deductPoints(user, usePoint);
		
		session.removeAttribute("tid");
		session.removeAttribute("usePoint");
		session.removeAttribute("amount");
		
		// 완료 페이지로 이동한다.
		return "redirect:" + "/booking/complete";
	}

	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public String fail(HttpServletRequest request, HttpSession session) {
		Booking book = (Booking)session.getAttribute("book");
		bookingService.removeBook(book);
		session.removeAttribute("book");
		session.removeAttribute("tid");
		session.removeAttribute("usePoint");
		session.removeAttribute("amount");
		System.out.println("fail");
		return "?payment=fail";
	}
	
	// 전액 취소 후 다시 예약 에서 취소 단계
	// 기존 예약에 대한 취소 처리
	@RequestMapping(value = "/cancelAndBooking", method = RequestMethod.GET)
	public String cancelAndBooking(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("book");
		int usePoint = (int)session.getAttribute("usePoint");
		
		Payment payment = paymentService.selectPayment(oldBook);
		String tid = payment.getTid();
		Integer paidMoney = payment.getAmount();
		
		HashMap<String, String> map = kakaoPayService.cancel(tid, paidMoney.toString());	// 전액 취소 요청

		if(map==null) {
			return "redirect:" + "/?cancelAndBooking=fail";
		}
		if(map.get("status").equals("CANCEL_PAYMENT")) {									// 전액 취소 성공
			// 이전 결제 정보 취소 처리
			paymentService.changeState(paymentService.selectPayment(oldBook), "cancelled");
			return "redirect:" + "/booking/cancelAndBooking";
		}
		return "redirect:" + "/?cancelAndBooking=fail";
		
	}
	
	// 차액 취소 후 예약변경 에서 취소 단계
	// 기존 예약에 대한 취소 처리
	@RequestMapping(value = "/cancelAndChange", method = RequestMethod.GET)
	public String cancelAndChange(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("book");
		Integer amount = (int)session.getAttribute("amount");
		Integer usePoint = (int)session.getAttribute("usePoint");
		
		String tid = paymentService.selectPayment(oldBook).getTid();
		
		HashMap<String, String> map = kakaoPayService.cancel(tid, amount.toString());		// 차액 취소 요청
		if(map==null) {
			return "redirect:" + "/?cancelAndChange=fail";
		}
		if(map.get("status").equals("PART_CANCEL_PAYMENT") ||
		   map.get("status").equals("CANCEL_PAYMENT")) {									// 차액 취소 성공
			// 이전 결제 정보 취소 처리
			paymentService.changeState(paymentService.selectPayment(oldBook), "cancelled");
			
			// 해당 결제 정보 저장
			Payment payment = new Payment();
			payment.setAmount(bookingService.getAmount(newBook));
			payment.setPoint(0); // 취소시 사용된 포인트를 돌려줘야 할지도?
			payment.setPg_name("KakaoPay");
			payment.setTid(tid);
			payment.setPay_type(map.get("pay_type"));
			payment.setState("paid");
			payment.setBook_no(newBook.getBook_no());
			paymentService.insertPayment(payment);
			
			return "redirect:" + "/booking/cancelAndChange";
		}
		
		return "redirect:" + "?cancelAndChange=fail";
	}
}