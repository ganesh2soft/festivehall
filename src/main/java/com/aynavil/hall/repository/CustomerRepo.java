package com.aynavil.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aynavil.hall.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
