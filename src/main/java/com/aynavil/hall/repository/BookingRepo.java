package com.aynavil.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aynavil.hall.entity.Booking;


public interface BookingRepo extends JpaRepository<Booking, Long>{

}
