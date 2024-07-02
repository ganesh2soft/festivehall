package com.aynavil.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aynavil.hall.entity.PartyHall;

public interface HallRepo extends JpaRepository <PartyHall,Long>{

}
