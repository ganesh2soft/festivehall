package com.aynavil.festivehall.service;

import java.util.List;
import java.util.Optional;

import com.aynavil.festivehall.entity.Avail;

public interface AvailService {

	public Avail addavailsfn(Avail avail);

	public Avail updateAvailsfn(Avail Avail,Long availId);

	public List<Avail> getAllAvailssfn();

	public Optional<Avail> getAvailsfn(Long availId);

	public void deleteAvailsfn(Long availId);

	public Optional<Avail> findByAvailId(Long availId);
}
