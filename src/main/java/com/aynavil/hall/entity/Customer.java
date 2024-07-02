package com.aynavil.hall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custId;
	private String custName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phone;
	private String address;
}
