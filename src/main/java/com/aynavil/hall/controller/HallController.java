package com.aynavil.hall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.hall.entity.PartyHall;
import com.aynavil.hall.service.HallService;
@RestController
@RequestMapping("/adminhall")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class HallController {

	@Autowired
	public HallService hallservice;
	
	@PostMapping("/hall/addhall")
	public void addhallcfn() {}
	
	@GetMapping("/hall/getallhalls")
	public List<PartyHall> gethallcfn(){
		return hallservice.gethallsfn();
	}
	
	@DeleteMapping("/hall/deletehall")
	public void deletehallcfn()
	{}
	@PutMapping("/hall/updatehall")
	public void updatehallcfn() {
		
	}
	
	
}
