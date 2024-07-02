package com.aynavil.festivehall.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.aynavil.festivehall.service.AvailService;

@RestController
@RequestMapping("/api/v1/availadmin")
@CrossOrigin(allowCredentials = "false", allowedHeaders = "*", origins = "http://localhost:4200", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AvailController {

	@Autowired
	AvailService availService;

	@PostMapping("/addavail")
	public Avail addavailcfn(@RequestBody Avail avail) {
		return availService.addavailsfn(avail);
	}

	@GetMapping("/getallavail")
	public ResponseEntity<List<Avail>> listAllavailcfn() {
		List<Avail> li = availService.getAllAvailssfn();

		if (li.isEmpty()) {
			return new ResponseEntity<List<Avail>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Avail>>(li, HttpStatus.OK);
	}

	@DeleteMapping("/deleteavail/{availid}")
	public void deleteavailcfn(@PathVariable("availid") Long availId) {
		System.out.println("At Controler layer"+availId);
		availService.deleteAvailsfn(availId);
	}

	@PutMapping("/updateavailbyavailid/{availid}")
	public Avail updateavailcfn(@RequestBody Avail avail,@PathVariable("availid") Long availId) {
		return availService.updateAvailsfn(avail, availId);
	}
}
