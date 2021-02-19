package com.jts.gangstudy.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jts.gangstudy.domain.Booking;
import com.jts.gangstudy.domain.Payment;
import com.jts.gangstudy.domain.User;
import com.jts.gangstudy.service.BookingService;
import com.jts.gangstudy.service.PaymentService;
import com.jts.gangstudy.service.UserService;


@Controller
@RequestMapping("/booking")
public class BookingController {
	private final int room_no = 1;

	@Autowired
	private UserService userService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private PaymentService paymentService;
	
	// 30분 간격으로 예약 시간이 되면 상태 변경
	@Scheduled(cron="0 */30 * * * *" )
	public void bookTrigger() {
		LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
		
		// 사용하는 예약의 상태변경
		List<Booking> usingList = bookingService.searchByDateTime(now);
		for(Booking book : usingList) {
			if(now.isEqual(book.getCheck_in()) && book.getState().equals("wait")) {			// 예약시간이 되면 use로 변경
				bookingService.changeState(book, Booking.State.use);
				User user = userService.getUser(book.getUser_no());
				Integer amount = paymentService.selectPayment(book).getAmount();
				
				userService.plusPoints(user, (amount/100) * 5);
			} else if(now.isEqual(book.getCheck_out()) && book.getState().equals("use")) {	// 예약이 종료되면 clear로 변경
				bookingService.changeState(book, Booking.State.clear);
			}
		}
		
		
		// 결제 미완료 등으로 남겨진 에약의 제거
		List<Booking> unchargeList = bookingService.searchByState("uncharge");
		for(Booking book : unchargeList) {
			LocalDateTime requestDateTime = book.getRequest_dt().plusHours(9);
			if(book.getCheck_in().isBefore(now)) {											// 지금보다 이전의 예약 제거
				bookingService.removeBook(book);
			} else if(requestDateTime.plusMinutes(10).isBefore(now)) {						// 요청한지 오래된 예약 제거
				bookingService.removeBook(book);
			}
		}
	}
	
	// 예약가능한 시작시간
	@ResponseBody
	@RequestMapping(value = "/startTime", method = RequestMethod.GET)
	public List<String> startTime(HttpServletRequest request, HttpSession session, 
			@RequestParam("date") String date, @RequestParam("book_no") Integer book_no) {
		List<Booking> books = bookingService.searchAlreadyBooked(book_no, date);
		List<String> times = bookingService.getStartTimes(books, date);
		return times;
	}

	// 예약가능한 종료시간
	@ResponseBody
	@RequestMapping(value = "/endTime", method = RequestMethod.GET)
	public List<String> endTime(HttpServletRequest request, HttpSession session) {
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		User user = (User)session.getAttribute("sUserId");
		Booking nextBook = bookingService.searchNextBook(user, date, startTime);
		List<String> times = bookingService.getEndTimes(nextBook, date, startTime);
		return times;
	}
	
	// makeBook 요청 시 요청한 user의 uncharge 상태 예약 모두 제거
	@ResponseBody
	@RequestMapping(value="/remove_uncharge", method = RequestMethod.GET)
	public void removeUnchargeBooks(HttpServletRequest request, HttpSession session) {
		User user = (User)session.getAttribute("sUserId");
		if(user==null) return;
		List<Booking> books = bookingService.searchByUserState(user, "uncharge");
		for(Booking book : books) {
			int result = bookingService.removeBook(book);
			if(result==0) {
				System.err.println("#BookingController::removeUnchargeBooks:: remove fail");
				System.err.println("#BookingController::removeUnchargeBooks:: book : " + book);
				System.err.println("#BookingController::removeUnchargeBooks:: user_no : " + user.getUser_no());
			}
		}
	}
	
	// 예약 취소가 가능한 조건인지 확인
	@ResponseBody
	@RequestMapping(value = "/cancelCheck", method = RequestMethod.GET)
	public String canCheck(HttpServletRequest request, HttpSession session, @RequestParam("book_no") int book_no) {
		User user = (User)session.getAttribute("sUserId");
		Booking book = bookingService.searchByBookNo(book_no);
		
		boolean canCancel = LocalDateTime.now().plusDays(1).isBefore(book.getCheck_in());
		if(!canCancel) {
			return "late";
		} else {
			return "ok";
		}
	}    

    
	@ResponseBody
	@RequestMapping(value = "danalCheck", method = RequestMethod.GET)
	public String danalCheck(HttpServletRequest request, HttpSession session, @RequestParam("book_no") int book_no) {
		
		User user = (User)session.getAttribute("sUserId");
		Booking book = bookingService.searchByBookNo(book_no);
		Payment payment = paymentService.selectPayment(book);
		if(payment.getPg_name().equals("KakaoPay")) { 
			return "false";
		}else {
			return "true";         
		}
		
	}
	

	// bookingList page - 예약 목록
	@UserLoginCheck
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView bookCheck(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("booking/bookingList");
		
		User user = (User)session.getAttribute("sUserId");
		List<Booking> books = bookingService.searchByUser(user);
		
		JSONArray array = new JSONArray();
		for(Booking book : books) {
			int point = 0;
			int amount = 0;
			if(!book.getState().equals("uncharge")) {
				Payment payment = paymentService.selectPayment(book);
				point = payment.getPoint();
				amount = payment.getAmount();
			}
			
			array.put(
					new JSONArray()
					.put(book.getBook_no())
					.put(book.getCheck_in().toLocalDate().toString() + " " +
						book.getCheck_in().toLocalTime().toString())
					.put(book.getCheck_out().toLocalDate().toString() + " " +
						book.getCheck_out().toLocalTime().toString())
					.put(bookingService.getTimeInterval(book))
					.put(book.getPeople() + "명")
					.put(book.getState())
					.put(point)
					.put(amount)
					.put(new JSONObject()
							.put("book_no", book.getBook_no())
							.put("state", book.getState()))
					);
		}

		mav.addObject("books", array);
		return mav;
	}
	
	// booking modify page - 결제 수정 페이지
	@UserLoginCheck
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView editBook(HttpServletRequest request, HttpSession session, @RequestParam("book_no") int book_no) {
		ModelAndView mav = new ModelAndView("pages/modify");
		User user = (User)session.getAttribute("sUserId");
		Booking book = bookingService.searchByBookNo(book_no);
		
		if(book == null || book.getUser_no() != user.getUser_no()) {
			mav.setViewName("redirect:" + "/");
			mav.addObject("msg", "잘못된 접근입니다.");
		} else if(!book.getState().equals("wait")) {
			mav.setViewName("redirect:" + "/");
			mav.addObject("msg", "수정이 불가능한 예약입니다.");
		} else {
			Payment payment = paymentService.selectPayment(book);
			
			int charge = bookingService.getAmount(book);
			int usedPoint = payment.getPoint();

			// mav add
			String timeInterval = bookingService.getTimeInterval(book);
			
			mav.addObject("startDate", book.getCheck_in().toLocalDate())
			.addObject("startTime", book.getCheck_in().toLocalTime())
			.addObject("endDate", book.getCheck_out().toLocalDate())
			.addObject("endTime", book.getCheck_out().toLocalTime())
			.addObject("people", book.getPeople())
			.addObject("timeInterval", timeInterval)
			.addObject("charge", charge)
			.addObject("usedPoint", usedPoint)
			.addObject("book_no", book_no);
		}
		
		return mav;
	}
	
	// booking shop page - 결제 직전 페이지
	@RequestMapping(value = "/make", method = RequestMethod.GET)
	public ModelAndView makeBook(HttpServletRequest request, HttpSession session,
			@RequestParam(value="dateInput", required = false) String date,
			@RequestParam(value="startTimeInput", required = false) String startTime,
			@RequestParam(value="endTimeInput",	  required = false) String endTime,
			@RequestParam(value="people",		  required = false) String people) {
		ModelAndView mav = new ModelAndView("pages/makecart");
		User user = (User)session.getAttribute("sUserId");
		Booking book = (Booking)session.getAttribute("book");	// 기존 예약이 있으면 가져옴
		
		if(book == null) {	// 기존 예약이 없으면 생성
			book = new Booking(date, startTime, endTime, Integer.parseInt(people), room_no, Booking.State.uncharge);
		}
		if(user == null) {		// 로그인이 안되었을시
			session.setAttribute("book", book);
			mav.setViewName("redirect:/signin");
			return mav;
		} else {
			book.setUser_no(user.getUser_no());
		}
		
		// mav add
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일 H시 mm분");
		String startDateTime = book.getCheck_in().format(formatter);
		String endDateTime = book.getCheck_out().format(formatter);
		String timeInterval = bookingService.getTimeInterval(book);
		int chargePerPeople = bookingService.getAmount(book) / book.getPeople();
		
		mav.addObject("startDateTime", startDateTime)
		.addObject("endDateTime", endDateTime)
		.addObject("timeInterval", timeInterval)
		.addObject("chargePerPeople", chargePerPeople)
		.addObject("people", book.getPeople())
		.addObject("point", user.getPoints())
		.addObject("charge", chargePerPeople*book.getPeople());
		
		// session registry
		session.setAttribute("book", book);
		return mav;
	}

	// booking shop page - 결제 요청 시
	@UserLoginCheck
	@ResponseBody
	@RequestMapping(value = "/make", method = RequestMethod.POST)
	public String makeSubmit(HttpServletRequest request, HttpSession session,
			@RequestParam("people") String peoples,
			@RequestParam("point") String point,
			@RequestParam("pg_name") String pg_name) {
		User user = (User)session.getAttribute("sUserId");
		Booking book = (Booking)session.getAttribute("book");

		// validation check
		int people = Integer.parseInt(peoples);
		if(people < 1 || people > 6) {
			return "?error=people";
		}
		
		// 뒤로가기 등으로 세션에서 예약이 제거된 경우
		if(book == null) {
			return "?error=bookIsNull";
		} else {
			if(bookingService.allowsBooking(book) == false) {
				return "?error=date";
			}
			// insert DB
			book.setPeople(people);
			String result = bookingService.insertBook(book);
			if(result.equals("duplicate")) {
				return "?booking=duplicate";
			}
		}
		
		
		int usePoint = Integer.parseInt(point);
		int charge = bookingService.getAmount(book);
		if(usePoint > user.getPoints() || usePoint < 0) {
			return "?error=point";
		}
		if(charge > 0 && charge < usePoint) {
			return "?error=usePoint";
		}
		// point로 전액 결제 시 결제요금 청구 안함.
		if(charge == usePoint) {
			paymentService.payByPoint(book, usePoint);
			bookingService.changeState(book, Booking.State.wait);
			userService.minusPoints(user, usePoint);
			return "/booking/check";
		}
		
		// session registry
		session.setAttribute("amount", charge);
		session.setAttribute("usePoint", usePoint);
		
		// 결제 페이지(선택페이지)로 이동
		if(pg_name.equals(Payment.PGName.KakaoPay.toString())) {
			return "/payment/kakaopay";
		} else if(pg_name.equals(Payment.PGName.Danal.toString())) {
			/* 아임포트 merchant_uid에 우리 부킹넘버를 보내서 관리하기 편하기위함. 
			   return으로 보내서 비동기방식으로 paybyDanal 매소드를 호출하였을시 
			   js에서 결과값  전역변수에 저장가능 */
			return String.valueOf(book.getBook_no());
		} else {
			return "?error=pg_name";
		}
	}
	
	//  카카오페이 예약 완료 처리
	@UserLoginCheck 
	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String complete(HttpServletRequest request, HttpSession session) {
		// 요청된 예약에 대해 예약번호를 얻고
		// 예약 번호로 된 결제가 있는지 확인한다.
		Booking book = (Booking)session.getAttribute("book");
		Payment payment = paymentService.selectPayment(book);
		session.removeAttribute("book");
		// 결제가 있을 경우 해당 예약을 완료 상태로 놓는다.
		if(payment != null && payment.getState() == Payment.State.paid) {
			bookingService.changeState(book, Booking.State.wait);
			return "redirect:" + "/booking/check";
		} else {
			return "redirect:" + "/?booking=fail";
		}
	}
	 

	
	
	// booking modify page - 결제 직전 페이지
	@UserLoginCheck
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView editSubmit(HttpServletRequest request, HttpSession session,
			@RequestParam("startDateInput") String startDate, @RequestParam("endDateInput") String endDate,
			@RequestParam("startTimeInput") String startTime, @RequestParam("endTimeInput") String endTime,
			@RequestParam("people") String people, @RequestParam("book_no")int book_no) {
		ModelAndView mav = new ModelAndView("pages/modifycart");
		User user = (User)session.getAttribute("sUserId");
		Booking oldBook = bookingService.searchByBookNo(book_no);
		Booking newBook = new Booking();
		newBook.setUser_no(user.getUser_no());
		newBook.setRoom_no(room_no);
		newBook.setCheck_in(startDate, startTime);
		newBook.setCheck_out(endDate, endTime);
		newBook.setPeople(people);
		newBook.setState("uncharge");
		
		// 예약 신청이 기존 예약과 동일한 경우
		if(newBook.getCheck_in().isEqual(oldBook.getCheck_in()) &&
			newBook.getCheck_out().isEqual(oldBook.getCheck_out()) &&
			newBook.getPeople() == oldBook.getPeople()) {
			
			mav.setViewName("redirect:/booking/check");
			return mav;
		}
		// registry booking in session
		session.setAttribute("oldBook", oldBook);
		session.setAttribute("newBook", newBook);
		
		// add view attribute
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일 H시 mm분");
		String startDateTime = newBook.getCheck_in().format(formatter);
		String endDateTime = newBook.getCheck_out().format(formatter);
		String timeInterval = bookingService.getTimeInterval(newBook);
		Payment payment = paymentService.selectPayment(oldBook);
		int cancelAmount = payment.getAmount();
		int addedAmount = bookingService.getAmount(newBook) - bookingService.getAmount(oldBook);
		
		mav.addObject("startDateTime", startDateTime)
		.addObject("endDateTime", endDateTime)
		.addObject("timeInterval", timeInterval)
		.addObject("people", people)
		.addObject("point", user.getPoints())
		.addObject("cancelAmount", cancelAmount)
		.addObject("addedAmount", addedAmount)
		.addObject("repayAmount", cancelAmount+addedAmount);
		return mav;
	}
	
	
	
	// booking modify bridge - 예약 변경 시 처리 브릿지
	@UserLoginCheck
	@ResponseBody
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String changeBridge(HttpServletRequest request, HttpSession session, @RequestParam("point") String point) {
		User user = (User)session.getAttribute("sUserId");
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("newBook");

		Payment oldPayment = paymentService.selectPayment(oldBook);									// 이전 결제
		int paidMoney = oldPayment.getAmount();														// 이전 결제 지불 금액
		int addedCharge = bookingService.getAmount(newBook) - bookingService.getAmount(oldBook);	// 추가요금
		
		// validation check
		String pointNums = point.replaceAll("[^0-9]","");
		int usePoint = Integer.parseInt(pointNums);
		if(user.getPoints() < usePoint || usePoint < 0) {
			return "?error=point";
		}
		if(addedCharge > 0 && usePoint > addedCharge) {
			return "?error=usePoint";
		}
		
		// 결제 요청 브릿지
		if(addedCharge < 0 && paidMoney < -1*addedCharge) {			// 돌려줘야 할 금액이 결제된 금액보다 큰 경우
			return "?payment=cancelFail";
		} else if (addedCharge == usePoint) {						// 추가금액을 포인트로 결제 or 변경 후 추가금액이 없음
			// 이전 결제 취소
			bookingService.changeState(oldBook, Booking.State.cancel);
			paymentService.changeState(oldPayment, Payment.State.cancelled);
			
			// 기존 결제로 예약-결제추가
			newBook.setState(Booking.State.wait);
			String result = bookingService.insertBook(newBook);
			if(result.equals("duplicate")) {
				return "?booking=duplicate";
			}
			
			// 기존 결제를 기반으로 새 결제 복사
			oldPayment.setState("paid");
			oldPayment.setBook_no(newBook.getBook_no());
			oldPayment.setPoint(oldPayment.getPoint()+usePoint);
			paymentService.insertPayment(oldPayment);
			
			// 포인트 사용값 처리
			userService.minusPoints(user, usePoint);
			return "/booking/check";
		} else if(paidMoney == 0) {									// 예전 결제 금액이 0원 (포인트 처리 등) 추가금액 결제
			bookingService.changeState(oldBook, Booking.State.cancel);
			paymentService.changeState(oldPayment, Payment.State.cancelled);
			
			// 추가 결제금액으로 예약-결제 추가
			session.setAttribute("amount", addedCharge - usePoint);
			session.setAttribute("usePoint", oldPayment.getPoint() + usePoint);
			session.setAttribute("book", newBook);
			return "redirect:/payment/kakaopay";
		} else {													// 일반적인 결제
			session.setAttribute("oldBook", oldBook);
			session.setAttribute("newBook", newBook);
			session.setAttribute("usePoint", usePoint);
			
			if(addedCharge > 0) {									// 추가 요금을 받아야 하는 경우
				session.setAttribute("amount", paidMoney + addedCharge - usePoint);	// 지불했던 금액 + 추가된 금액 - 사용한 포인트
				return "/payment/cancelAndBooking";
			} else {												// 취소 요금을 줘야 하는 경우
				session.setAttribute("amount", addedCharge);
				return "/payment/cancelAndChange";
			}
		}
	}
	
	// booking more payment - 예약 변경으로 인한 추가 결제 처리
	@UserLoginCheck
	@RequestMapping(value = "/cancelAndBooking", method = RequestMethod.GET)
	public String cancelAndBooking(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("newBook");
		int usePoint = (int)session.getAttribute("usePoint");
		
		// session registry
		session.setAttribute("book", newBook);

		session.removeAttribute("oldBook");
		session.removeAttribute("newBook");
		// 새 예약에 대한 요청
		return "redirect:/payment/kakaopay";
	}
	
	// booking less payment - 예약 변경으로 인한 차액 환불 처리
	@UserLoginCheck
	@RequestMapping(value = "/cancelAndChange", method = RequestMethod.GET)
	public String cancelAndChange(HttpServletRequest request, HttpSession session) {
		Booking oldBook = (Booking)session.getAttribute("oldBook");
		Booking newBook = (Booking)session.getAttribute("newBook");
		int usePoint = (int)session.getAttribute("usePoint");
		Payment payment = (Payment)session.getAttribute("payment");

		// 결제 취소 성공시
		// 기존 예약을 취소로 변경
		bookingService.changeState(oldBook, Booking.State.cancel);
		String result = bookingService.insertBook(newBook);
		if(result.equals("duplicate")) {
			return "?booking=duplicate";
		}
		payment.setBook_no(newBook.getBook_no());
		paymentService.insertPayment(payment);

		// 새 예약 등록
		bookingService.changeState(newBook, Booking.State.wait);

		session.removeAttribute("oldBook");
		session.removeAttribute("newBook");
		session.removeAttribute("amount");
		session.removeAttribute("usePoint");
		session.removeAttribute("payment");
		// 변경 결과 페이지
		return "redirect:/booking/check";
	}
	

	
}
