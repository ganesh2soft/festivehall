package com.aynavil.hall.service;

import java.util.List;

import com.aynavil.hall.entity.Booking;

public interface BookingHallServiceInterf {
	public void Bookhall(Booking booking);
	public List<Booking> getBookingdetails();
	public void deleteBookingdetails(Long bookingid);
}


