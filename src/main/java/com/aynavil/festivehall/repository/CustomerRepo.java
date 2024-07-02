package com.aynavil.festivehall.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aynavil.festivehall.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustId(Long custId);
   // public Customer findCustomerByCustname(String custom);
	public Customer findCustomerByEmail(String customeremail);
}
