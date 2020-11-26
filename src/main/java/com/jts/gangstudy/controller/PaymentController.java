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
		// 상품명
		// 상품 수량
		// 상품 총액
		// 상품 비과세 금액?
		// redirect url
		// 취소 url
		//
		ModelAndView mav = new ModelAndView("/payment/choose");
		return mav;
	}

	@RequestMapping(value = "/kakaopay", method = RequestMethod.GET)
	public String kakaopay(HttpServletRequest request, HttpSession session) {
		int amount = (int)session.getAttribute("amount");
		
		Device device = DeviceUtils.getCurrentDevice(request);
		String deviceType;
		if (device.isMobile()) {
			deviceType = "mobile";
		} else if (device.isTablet()) {
			deviceType = "tablet";
		} else {
			deviceType = "desktop";
		}
		
		String domain = request.getScheme()+"://"+request.getServerName() + ":" +request.getServerPort();
		System.out.println(domain);
		HashMap<String, String> map = kakaoPayService.ready(domain, deviceType, amount);
		
		session.setAttribute("tid", map.get("tid"));
		return "redirect:" + map.get("url");
	}

	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String complete(HttpServletRequest request, HttpSession session) {
		User sUserId = (User)session.getAttribute("sUserId");
		Booking book = (Booking)session.getAttribute("book");
		String tid = (String)session.getAttribute("tid");
		int usePoint = (int)session.getAttribute("usePoint");

		String pg_token = request.getParameter("pg_token");
		
		// 결제 완료 요청
		HashMap<String, String> payInfo = kakaoPayService.getPayInfo(tid, pg_token);

		// 결제 정보를 저장한다.
		int amount = bookingService.getCharge(book) - usePoint;
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setPoint(usePoint);
		payment.setPg_name("KakaoPay");
		payment.setTid(tid);
		payment.setPay_type(payInfo.get("pay_type"));
		payment.setState("paid");
		payment.setBook_no(book.getBook_no());
		
		paymentService.insertPayment(payment);

		// 예약에 대해서 uncharge -> wait으로 변경한다.
		bookingService.changeState(book, "wait");
		
		
		Integer remainPoint = (Integer.parseInt(sUserId.getPoints()) - usePoint);
		System.out.println("[debug- complete] sUserId.user_no: " + sUserId.getUser_no()
							+ ", usePoint : " + usePoint
							+ ", sUserId.getPoints : " + sUserId.getPoints()
							+ ", remainPoint : " + remainPoint);
		userService.updatePoints(sUserId, remainPoint.toString());
		sUserId.setPoints(remainPoint.toString());
		
		session.removeAttribute("book");
		session.removeAttribute("tid");
		session.removeAttribute("usePoint");
		
		// 완료 페이지로 이동한다.
		return "redirect:" + "/booking/check";
	}

	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public String fail(HttpServletRequest request, HttpSession session) {
		Booking book = (Booking)session.getAttribute("book");
		bookingService.removeBook(book);
		session.removeAttribute("payment");
		session.removeAttribute("book");
		session.removeAttribute("tid");
		System.out.println("fail");
		return "/";
	}
	
	// 전액 취소 후 다시 예약 에서 취소 단계
	// 기존 예약에 대한 취소 처리
	@RequestMapping(value = "/cancelAndBooking", method = RequestMethod.GET)
	public String cancelAndBooking(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("newBook");
		int usePoint = (int)session.getAttribute("usePoint");
		
		String tid = paymentService.selectPayment(oldBook).getTid();
		Integer amount = bookingService.getCharge(oldBook);
		
		HashMap<String, String> map = kakaoPayService.cancel(tid, amount.toString());	// 전액 취소 요청

		if(map.get("status").equals("CANCEL_PAYMENT")) {	// 전액 취소 성공
			// 이전 결제 정보 취소 처리
			paymentService.changeState(paymentService.selectPayment(oldBook), "cancelled");
			
			return "redirect:" + "/booking/cancelAndBooking";
		}
		return "redirect:" + "?cancelAndBooking=fail";
		
	}
	
	// 차액 취소 후 예약변경 에서 취소 단계
	// 기존 예약에 대한 취소 처리
	@RequestMapping(value = "/cancelAndChange", method = RequestMethod.GET)
	public String cancelAndChange(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("newBook");
		int usePoint = (int)session.getAttribute("usePoint");
		
		String tid = paymentService.selectPayment(oldBook).getTid();
		Integer amount = -(bookingService.getCharge(newBook) - paymentService.selectPayment(oldBook).getAmount());
		
		HashMap<String, String> map = kakaoPayService.cancel(tid, amount.toString());	// 차액 취소 요청
		if(map.get("status").equals("PART_CANCEL_PAYMENT")) {	// 차액 취소 성공
			// 이전 결제 정보 취소 처리
			paymentService.changeState(paymentService.selectPayment(oldBook), "cancelled");

			session.setAttribute("tid", map.get("tid"));
			session.setAttribute("pay_type", map.get("pay_type"));
			
			return "redirect:" + "/booking/cancelAndChange";
		}
		
		return "redirect:" + "?cancelAndChange=fail";
	}
}