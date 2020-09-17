package com.jts.gangstudy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.gangstudy.domain.Booking;
import com.jts.gangstudy.mapper.BookingMapper;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingMapper mapper;
	private Calendar cal;
	
	private int dateSize = 7;			// 예약 신청이 가능한 기간
	private int minuteSize = 30;		// 에약 신청 시간 단위
	private int startHour = 9;			// 예약 가능한 시작 시간
	private int endHour = 23;			// 예약 가능한 종료 시간

	// 전체 예약 목록 (디버깅용)
	@Override
	public List<Booking> viewAll() {
		return mapper.viewAll();
	}

	// 선택 가능한 날짜 목록
	@Override
	public List<String> getDateSelectOptions() {
		return getDates(dateSize);
	}

	// 해당 날짜의 예약 목록
	@Override
	public List<Booking> getDateBooking(String date) {
		return mapper.viewDate(date);
	}
	
	// 시작일 기준의 시작시간 목록
	@Override
	public List<String> getCITimes(List<Booking> books) {
		// 예약 시간 단위로 모든 예약 시간 생성
		List<String> ciList = getTimes(startHour, endHour, minuteSize);
		
		// 기존 예약을 예약 시간에서 제거
		for(Booking book : books) {
			removeTimes(ciList, book.getCi(), book.getCo(), minuteSize);
		}
		return ciList;
	}

	// 시작시간 기준의 종료시간 목록
	// 시작시간 기준의 종료시간 목록
	@Override
	public List<String> getCOTimes(String ci, String[] ciArray) {
		String time;
		List<String> coList = new ArrayList<>();
		List<String> ciList = Arrays.asList(ciArray);

		int hour = getHour(ci);
		int min = getMinute(ci);
		cal = Calendar.getInstance();
		setTime(cal, hour, min);
		
		// 종료 시간 추가
		do {
			cal.add(Calendar.MINUTE, minuteSize);
			time = getTime(cal);
			coList.add(time);
		} while(ciList.contains(time));
		return coList;
	}

	// 예약 정보 생성
	// 예약 정보 생성
	@Override
	public Booking createBook(String book_dt, String ci, String co, int people) {
		return new Booking(1, 1, book_dt, ci, co, people, "wait");
	}

	// 예약 추가
	// 예약 추가
	@Override
	public void insertBook(Booking book) {
		mapper.insertBook(book);
	}

	// 현재 시간 반환
	// calendar의 시간을 구하는 함수
	public String getTime(Calendar cal) {
		String time;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		time = String.format("%02d:%02d", hour, min);
		return time;
	}

	// 현재 시간 지정
	// calendar의 시간을 설정하는 함수
	public void setTime(Calendar cal, int hour, int minute) {
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		return;
	}

	// format(%02d:%02d)의 시 반환
	// time format(%02d:%02d) 에서 hour를 얻는 함수
	public int getHour(String time) {
		return Integer.parseInt(time.substring(0, 2));
	}

	// format(%02d:%02d)의 분 반환
	// time format(%02d:%02d) 에서 minute를 얻는 함수
	public int getMinute(String time) {
		return Integer.parseInt(time.substring(3, 5));
	}

	// date 목록 반환
	// 예약 가능한 날짜 배열 구하는 함수
	public List<String> getDates(int dateSize) {
		SimpleDateFormat calFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dates = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		
		for(int i = 0; i < dateSize; i++) {
			dates.add(calFormat.format(cal.getTime()));
	        cal.add(Calendar.DATE, 1);
		}
		return dates;
	}

	// time 목록 반환
	// 예약 가능한 시간을 구하는 함수
	public List<String> getTimes(int start, int end, int minuteSize) {
		List<String> times = new ArrayList<>();
		String time;
		Calendar cal = Calendar.getInstance();
		
		for(setTime(cal, start, 0); cal.get(Calendar.HOUR_OF_DAY) != end; cal.add(Calendar.MINUTE, minuteSize)) {
			time = getTime(cal);
			times.add(time);
		}
		return times;
	}
	
	// 일정구간 예약을 지우는 함수
	public void removeTimes(List<String> times, String start, String end, int minuteSize){
		int hour, min;
		Calendar cal = Calendar.getInstance();
		
		hour = getHour(start);
		min = getMinute(start);
		setTime(cal, hour, min);
			
		for(String time = getTime(cal); !time.equals(end); cal.add(Calendar.MINUTE, minuteSize), time = getTime(cal)) {
			times.remove(time);
		}
	}
}