package com.aynavil.hall.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	private int customerId; //foreign key
	private String customerName;
	private int hallId;  //foreign key
	private int hallName;
	private Date fromdate;
	private Date todate;
	private int expectedTotalguest;
	
	
}
