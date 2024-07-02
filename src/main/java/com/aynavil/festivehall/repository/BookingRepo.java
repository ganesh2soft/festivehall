package com.aynavil.festivehall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.festivehall.entity.Booking;
import com.aynavil.festivehall.entity.Customer;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{
	
	Booking findByBookingId(Long bookingId);
	
	List<Booking> findByCustomerCustId(Long custId);

}

