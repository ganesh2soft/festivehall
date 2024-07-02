package com.aynavil.hall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PartyHall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hallId;
	private String hallName; //Golden Park
	private String hallDesc; //Premium
	private int hallCapacity; //1000
	private String hallAc; //AC
	private String diningCapacity; //500
	private String diningType; // lawn or buffet or regular
	private int hallChargeperday; //700000
}
