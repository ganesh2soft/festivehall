package com.aynavil.hall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aynavil.hall.entity.Booking;
import com.aynavil.hall.repository.BookingRepo;

public class BookingHallService implements BookingHallServiceInterf{

	
	@Autowired
	public BookingRepo bookingrepo;
	@Override
	public void Bookhall(Booking booking) {

		bookingrepo.save(booking);
	}

	@Override
	public List<Booking> getBookingdetails() {
		
		return bookingrepo.findAll(); 
	}

	@Override
	public void deleteBookingdetails(Long bookingid) {
		
		// return bookingrepo.deleteBookingdetails(bookingid);
		bookingrepo.deleteById(bookingid);
	}

}

