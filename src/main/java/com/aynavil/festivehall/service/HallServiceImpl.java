package com.aynavil.festivehall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aynavil.festivehall.entity.PartyHall;
import com.aynavil.festivehall.repository.HallRepo;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	HallRepo hallrepo;
	@Override
	public PartyHall addhallsfn(PartyHall partyhall) {
		// TODO Auto-generated method stub
	 return hallrepo.save(partyhall);
	 }

	@Override
	public List<PartyHall> gethallsfn() {
		// TODO Auto-generated method stub
		return hallrepo.findAll();
	}
	@Override
	public void deletehallsfn(Long hallId) {
		
		hallrepo.deleteById(hallId);
	}

	@Override
	public PartyHall updatehallsfn(PartyHall partyhall, Long hallId) {
		// TODO Auto-generated method stub
		return hallrepo.save(partyhall);
	}
}
