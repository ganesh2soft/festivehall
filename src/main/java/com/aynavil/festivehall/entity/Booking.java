package com.aynavil.festivehall.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;

	private Date fromDate;
	private Date toDate;
	private int expectedTotalGuest;
	private Date dateOfBooking;

	
	@ManyToOne
	@JoinColumn(name = "availcode", referencedColumnName = "availId")
	private Avail avail; 

	@ManyToOne
	@JoinColumn(name = "customercode", referencedColumnName = "custId")
	private Customer customer; //This should be Customer entity not customerid
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", expectedTotalGuest=" + expectedTotalGuest + ", dateOfBooking=" + dateOfBooking + ", avail=" + avail
				+ ", customer=" + customer + "]";
	}

	public Booking(Long bookingId, Date fromDate, Date toDate, int expectedTotalGuest, Date dateOfBooking, Avail avail,
			Customer customer) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.expectedTotalGuest = expectedTotalGuest;
		this.dateOfBooking = dateOfBooking;
		this.avail = avail;
		this.customer = customer;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getExpectedTotalGuest() {
		return expectedTotalGuest;
	}

	public void setExpectedTotalGuest(int expectedTotalGuest) {
		this.expectedTotalGuest = expectedTotalGuest;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}



	public Avail getAvail() {
		return avail;
	}

	public void setAvail(Avail avail) {
		this.avail = avail;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} // foreign key  custId
}