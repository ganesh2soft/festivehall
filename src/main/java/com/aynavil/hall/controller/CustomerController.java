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

import com.aynavil.hall.entity.Customer;
import com.aynavil.hall.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class CustomerController {
	@Autowired
	public CustomerService customerservice;
	
	@PostMapping("/createcustomer")
	public Customer createCust(@RequestBody Customer customer) {
		customerservice.createCust(customer);
		return customer;
	}
	
	
	@GetMapping("/allcustomers")
	public ResponseEntity<List<Customer>> listAllUserdetailscfn() {
		List<Customer> li = customerservice.getAllCustomerssfn();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	
	
	
	/*
	@DeleteMapping("/deletecust/{custid}")
	public ResponseEntity<List<Customer>> deleteCustomcfn(@PathVariable("custid") Long custid) {
		List<Customer> li = customerservice.deleteCust(custid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	
	
	*/
	/*
	@PutMapping("/updatecust")
	public ResponseEntity<List<Customer>> updateCustcfn(@RequestBody Customer customer) {
		List<Customer> li = customerservice.updateCust(customer);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	*/
	
	
}
