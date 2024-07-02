package com.aynavil.festivehall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aynavil.festivehall.entity.PartyHall;

@Repository
public interface HallRepo extends JpaRepository <PartyHall,Long>{

	Optional<PartyHall> findByHallId(Long hallId);
	
}
