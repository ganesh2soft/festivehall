package com.aynavil.festivehall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aynavil.festivehall.entity.Avail;
import com.aynavil.festivehall.entity.PartyHall;
import com.aynavil.festivehall.service.HallService;
@RestController
@RequestMapping("/api/v1/adminhall")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class HallController {

	@Autowired
	public HallService hallservice;
	
	@PostMapping("/addhall")
	public PartyHall addhallcfn(@RequestBody PartyHall partyhall) {
		return hallservice.addhallsfn(partyhall);
	}
	
	@GetMapping("/getallhalls")
	public List<PartyHall> gethallcfn(){
		return hallservice.gethallsfn();
	}
	
	@DeleteMapping("/deletehall/{hallid}")
	public void deletehallcfn(@PathVariable("hallid") Long hallid)
	{
		hallservice.deletehallsfn(hallid);
	}
	
	@PutMapping("/updatehallbyhallid/{hallid}")
	public PartyHall updatehallcfn(PartyHall partyhall,@PathVariable("hallid") Long hallId ) {
		return hallservice.updatehallsfn(partyhall, hallId);
	}
	
	
	
}
