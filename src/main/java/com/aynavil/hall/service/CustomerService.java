package com.aynavil.hall.service;

import java.util.List;

import com.aynavil.hall.entity.Customer;

public interface CustomerService {
	public void createCust(Customer customer);
	
	public Customer updateCustsfn(Customer customer);
	public List<Customer> getAllCustomerssfn();
	public Customer getCustsfn(Long custid);
	public void deleteCustsfn(Long custid);
}
