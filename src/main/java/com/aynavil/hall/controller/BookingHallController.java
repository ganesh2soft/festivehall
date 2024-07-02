package com.aynavil.hall.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.hall.entity.Booking;
import com.aynavil.hall.service.BookingHallService;
@RestController
@RequestMapping("/booking")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class BookingHallController {
	@Autowired
	BookingHallService bookinghallservice;
	
	//Tester
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Booking Hall Service";
	}
	
	
	@GetMapping("/bookhalldetails")
	public ResponseEntity<List<Booking>> listbookingdetailscfn() {
		List<Booking> li = bookinghallservice.getBookingdetails();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
	}
	
	@PostMapping("/bookthehall")
	public Booking Bookhallcfn(@RequestBody Booking booking) {
		bookinghallservice.Bookhall(booking);
		return booking;
	}
	/*
	@DeleteMapping("/delyourbooking/{bookingid}")
	public ResponseEntity<List<Booking>> deleteBookcfn(@PathVariable("bookingid") Long bookingid) {
		List<Booking> li = bookinghallservice.deleteBookingdetails(bookingid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
	}
*/
}
