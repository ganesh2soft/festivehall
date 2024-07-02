package com.aynavil.hall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aynavil.hall.entity.Customer;
import com.aynavil.hall.repository.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerRepo customerrepo;

	@Override
	public void createCust(Customer customer) {
	
		customerrepo.save(customer);

	}

	@Override
	public List<Customer> getAllCustomerssfn() {
		return customerrepo.findAll(); 
	}

	@Override
	public Customer getCustsfn(Long custid) {
		return customerrepo.getById(custid);
	}

	@Override
	public void deleteCustsfn(Long custid) {
		customerrepo.deleteById(custid);
		
	}

	@Override
	public Customer updateCustsfn(Customer customer) {
		return customerrepo.save(customer);
	}

}
