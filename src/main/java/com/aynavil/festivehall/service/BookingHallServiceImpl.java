package com.aynavil.festivehall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aynavil.festivehall.entity.Booking;
import com.aynavil.festivehall.entity.Customer;
import com.aynavil.festivehall.repository.BookingRepo;
import com.aynavil.festivehall.repository.CustomerRepo;



@Service
public class BookingHallServiceImpl implements BookingHallService {

	@Autowired
	public BookingRepo bookingrepo;

	@Autowired
	public CustomerRepo customerrepo;
	@Override
	public Booking bookhallsfn(Booking booking) {
		
		 return bookingrepo.save(booking);
	}


	@Override
	public List<Booking> getBookingdetailssfn() {

		return bookingrepo.findAll();
	}

	@Override
	public void deleteBookingdetailssfn(Long bookingId) {

		bookingrepo.deleteById(bookingId);
	}

	@Override
	public Booking updateBookingsfn(Booking booking, Long bookingId) {
		// TODO Auto-generated method stub
		return bookingrepo.save(booking);
	}

	@Override
	public Booking getBookingbyidsfn(Long bookingId) {
	return bookingrepo.findByBookingId(bookingId);
	}


	

	@Override
	public List<Booking> getBookbycustIdsfn(Long custId) {
		return bookingrepo.findByCustomerCustId(custId);
	}

	

	
	
	
	
	

//	@Override
//	public Booking bookhallsfn(Booking booking, Long hid, Long cid) {
//
//		
//		Customer customer = customerrepo.findById(cid)
//				.orElseThrow(() -> new EntityNotFoundException("Customer not found"));
//		
//		booking.setCustomer(customer);
//		
//		System.out.println("At service layer" + booking);
//		return bookingrepo.save(booking);
//	}

//	@Override
//	public Booking bookhallsfn(Booking booking) {
//
////	PartyHall partyhall= hallrepo.findByHallId(booking.getHallId())
////	                                        .orElseThrow(() -> new EntityNotFoundException("PartyHall not found"));
////	customerrepo.findById(booking.getCustomerId())
////			.orElseThrow(() -> new EntityNotFoundException("Customer not found"));
//		booking.setCustomerId(booking.getCustomerId());
//		booking.setHallId(booking.getHallId());
//		System.out.println("At service layer" + booking);
//		return bookingrepo.save(booking);
//
//	}

}
