package com.aynavil.festivehall.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aynavil.festivehall.entity.Customer;
import com.aynavil.festivehall.repository.CustomerRepo;


@Service
public class CustomerServiceImple implements CustomerService {
	@Autowired
	public CustomerRepo customerrepo;

	@Override
	public void createCustsfn(Customer customer) {
	
		customerrepo.save(customer);

	}

	public List<Customer> getAllCustomerssfn() {
		return customerrepo.findAll(); 
	}

	@Override
	public Optional<Customer> getCustsfn(Long custid) {
		return customerrepo.findById(custid);
	}
	
	public Optional<Customer> findByCustId(Long custId) {
		return customerrepo.findByCustId(custId);
	}
	@Override
	public void deleteCustsfn(Long custId) {
		customerrepo.deleteById(custId);
		
	}

	@Override
	public Customer updateCustsfn(Customer customer, Long custId) {
		// TODO Auto-generated method stub
		return customerrepo.save(customer);
	}
}
