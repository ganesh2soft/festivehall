package com.aynavil.festivehall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.festivehall.entity.Avail;



@Repository
public interface AvailRepo extends JpaRepository<Avail, Long>{

}
