package com.jts.gangstudy.mapper;

import java.util.HashMap;
import java.util.List;

import com.jts.gangstudy.domain.Booking;

public interface BookingMapper {
	public void insertBook(Booking book);
	public void deleteBook(int book_no);
	public void updateState(HashMap<String, String> map);
	
	public List<Booking> selectByDate(String date);
	public List<Booking> selectByDateTime(String dateTime);
	public List<Booking> selectByDateFirst(String date);
	public List<Booking> selectByState(String state);
	public List<Booking> selectByUserState(HashMap<String, String> map);
	
	public int selectDuplicate(HashMap<String, String> map);
	public List<Booking> viewOvernight(String date);
}
