package com.aynavil.festivehall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.festivehall.entity.Booking;
import com.aynavil.festivehall.entity.Customer;
import com.aynavil.festivehall.service.BookingHallService;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin(allowCredentials = "false", allowedHeaders = "*", origins = "http://localhost:4200", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class BookingHallController {
	@Autowired
	BookingHallService bookinghallservice;
	
	

	// Tester
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Booking Hall Service";
	}

	@GetMapping("/bookhalldetails")
	public ResponseEntity<List<Booking>> listbookingdetailscfn() {
		List<Booking> li = bookinghallservice.getBookingdetailssfn();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(li, HttpStatus.OK);
	}
	
	/*
	 * Below is one of the CRUD operation of Booking Entity
	 */
	@GetMapping("/getbookingbyid/{bookingid}")
	public ResponseEntity<Booking> listbookingbyidcfn(@PathVariable("bookingid")Long bookingId) {
		
		Booking booking = bookinghallservice.getBookingbyidsfn(bookingId);
		if (booking==null) {
			return new ResponseEntity<Booking>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	/*
	 * Below is Getting Booking details of particular Customer based on custid
	 */
	@GetMapping("/getbookingbycustid/{custid}")
	public ResponseEntity<List<Booking>> listbookbycustidcfm(@PathVariable("custid")Long custId){
		
		System.out.println("At Controller level"+custId);
		List<Booking> listbooking=bookinghallservice.getBookbycustIdsfn(custId);
		if (listbooking.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(listbooking, HttpStatus.OK);
	}
	
	
	

//	@PostMapping("/bookthehall/{phallId}/{customerId}")
//	public Booking Bookhallcfn(@RequestBody Booking booking, @PathVariable(value = "phallId") Long phallId,
//			@PathVariable(value = "customerId") Long customerId) {
//		System.out.println("At controller" + booking);
//		bookinghallservice.bookhallsfn(booking, phallId, customerId);
//		return booking;
//	}
    @PostMapping("/bookingreq")
    public Booking bookhallcfn(@RequestBody Booking booking) {
    	System.out.println("****************"+booking);
    	return bookinghallservice.bookhallsfn(booking);
    }
	@DeleteMapping("/deletebooking/{bookingid}")
	public void deleteCustomcfn(@PathVariable("bookingid") Long bookid) {
		bookinghallservice.deleteBookingdetailssfn(bookid);

	}
//	@PostMapping("/bookthehall")
//	public Booking Bookhallcfn(@RequestBody Booking booking) {
//		System.out.println("At controller"+booking);
//		Booking lbooking = new Booking();
//		
//		lbooking.setHallId(booking.getHallId());
//		booking.setCustomerId(booking.getCustomerId());
//		System.out.println("At controller"+booking);
//		bookinghallservice.bookhallsfn(lbooking);
//		return booking;
//	}

	@DeleteMapping("/delyourbooking/{bookingid}")
	public void deleteBookcfn(@PathVariable("bookingid") Long bookingid) {
		bookinghallservice.deleteBookingdetailssfn(bookingid);

	}
	
	@PutMapping("/updatebookingbybookingid/{bookingid}")
	public Booking updateBookcfn(@RequestBody Booking booking,@PathVariable("availid") Long availId) {
		return bookinghallservice.updateBookingsfn(booking, availId);
	}
}
