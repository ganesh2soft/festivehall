package com.aynavil.festivehall.service;

import java.util.List;
import java.util.Optional;


import com.aynavil.festivehall.entity.Customer;

public interface CustomerService {
	public void createCustsfn(Customer customer);
	public Customer updateCustsfn(Customer customer,Long custId);
	public List<Customer> getAllCustomerssfn();
	public Optional<Customer> getCustsfn(Long custid);
	public void deleteCustsfn(Long custId);
	public Optional<Customer> findByCustId(Long custId);
}
