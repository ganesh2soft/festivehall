package com.aynavil.hall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aynavil.hall.entity.Customer;
import com.aynavil.hall.entity.PartyHall;
import com.aynavil.hall.repository.HallRepo;

public class HallServiceImpl implements HallService {

	@Autowired
	HallRepo hallrepo;
	@Override
	public void addhallsfn() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<PartyHall> gethallsfn() {
		// TODO Auto-generated method stub
		return hallrepo.findAll();
		
	}

	@Override
	public void deletehallsfn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatehallsfn() {
		// TODO Auto-generated method stub
		
	}

}
