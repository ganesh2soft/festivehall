package com.aynavil.festivehall.service;

import java.util.List;

import com.aynavil.festivehall.entity.PartyHall;

public interface HallService {
	
	public PartyHall addhallsfn(PartyHall partyhall);
	public List<PartyHall> gethallsfn();
	public void deletehallsfn(Long hallId);	
	public PartyHall updatehallsfn(PartyHall partyhall, Long hallId);
	
}

