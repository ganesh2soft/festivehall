package com.aynavil.festivehall.service;

import java.util.List;

import com.aynavil.festivehall.entity.Booking;
import com.aynavil.festivehall.entity.Customer;

public interface BookingHallService {
	//public Booking bookhallsfn(Booking booking,Long hid,Long cid);
	public Booking bookhallsfn(Booking booking);
	public List<Booking> getBookingdetailssfn();
	public void deleteBookingdetailssfn(Long bookingId);
	public Booking updateBookingsfn(Booking booking,Long bookingId);
	public Booking getBookingbyidsfn(Long bookingId);
	public List<Booking> getBookbycustIdsfn(Long custId);
}


