package com.aynavil.festivehall.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.aynavil.festivehall.entity.Customer;
import com.aynavil.festivehall.repository.CustomerRepo;
import com.aynavil.festivehall.service.CustomerService;


@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class CustomerController {
	@Autowired
	public CustomerService customerservice;
 	@Autowired
	CustomerRepo customerRepo; 
	
	@GetMapping("/customerlogin")
	public ResponseEntity<Customer> processRequest() {
		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer welcomeUser = customerRepo.findCustomerByEmail(auth.getName());
		System.out.println("Response body user details=========" + welcomeUser);
		try {
            // Introduce a 3-second (3000 milliseconds) delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
		
		   ResponseEntity<Customer> responseEntity = new ResponseEntity<>(welcomeUser, HttpStatus.OK);
	       return responseEntity;
	
	}	
	
	@PostMapping("/createcustomer")
	public Customer createCustcfn(@RequestBody Customer customer) {
		customerservice.createCustsfn(customer);
		return customer;
	}
	
    @GetMapping("/allcustomers")
	public ResponseEntity<List<Customer>> listAllUserdetailscfn() {
		System.out.println("Received Request from remote");
		List<Customer> li = customerservice.getAllCustomerssfn();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecust/{custid}")
	public void deleteCustomcfn(@PathVariable("custid") Long custid) {
		customerservice.deleteCustsfn(custid);
			
	}
	
	@PutMapping("/updatecustbycustid/{custid}")
	public Customer updateCustcfn(@RequestBody Customer customer, @PathVariable("custid") Long custId) {
		return customerservice.updateCustsfn(customer, custId);

	}
	
}
