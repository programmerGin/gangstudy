package com.jts.gangstudy.mapper;

import java.util.HashMap;
import java.util.List;

import com.jts.gangstudy.domain.Booking;

public interface BookingMapper {
	public List<Booking> viewAll();
	public List<Booking> existsBooking(HashMap<String, String> val);
	public void addBooking(Booking book);
}
