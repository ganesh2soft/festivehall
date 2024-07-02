package com.aynavil.hall.service;

import java.util.List;

import com.aynavil.hall.entity.Customer;
import com.aynavil.hall.entity.PartyHall;

public interface HallService {
	
	public void addhallsfn();
	public List<PartyHall> gethallsfn();
	public void deletehallsfn();
	public void updatehallsfn();
}

