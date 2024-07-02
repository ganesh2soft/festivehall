package com.aynavil.festivehall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aynavil.festivehall.entity.Avail;
import com.aynavil.festivehall.repository.AvailRepo;
@Service
public class AvailServiceImpl implements AvailService {

	@Autowired
	AvailRepo availrepo;
	@Override
	public Avail addavailsfn(Avail avail) {
		 return availrepo.save(avail);
	}

	@Override
	public List<Avail> getAllAvailssfn() {
		return availrepo.findAll();
	}

	@Override
	public Optional<Avail> getAvailsfn(Long availId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteAvailsfn(Long availId) {
		System.out.println("At Service layer, "+availId);
	  availrepo.deleteById(availId);
		
	}

	@Override
	public Optional<Avail> findByAvailId(Long availId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Avail updateAvailsfn(Avail avail, Long availId) {
		// TODO Auto-generated method stub
		return availrepo.save(avail);
	}

}
