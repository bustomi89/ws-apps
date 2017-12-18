package com.dybar.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.dybar.entity.MDoctor;
import com.dybar.service.IDoctorService;

@Controller
@RequestMapping("doctor")
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = {"*"})
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	//getMDoctorById
	@GetMapping("doctor")
	public ResponseEntity<MDoctor> getMDoctorById(@RequestParam("id") BigDecimal id) {
		MDoctor MDoctor = doctorService.getDoctorById(id);
		return new ResponseEntity<MDoctor>(MDoctor, HttpStatus.OK);
	}
	
	//getAllMDoctor
	@GetMapping("all-doctor")
	public ResponseEntity<List<MDoctor>> getAllMDoctor() {
		List<MDoctor> list = doctorService.getAllDoctor();
		return new ResponseEntity<List<MDoctor>>(list, HttpStatus.OK);
	}
	
	//createMDoctor
	@PostMapping("doctor")
	public ResponseEntity<Void> createMDoctor(@RequestBody MDoctor MDoctor, UriComponentsBuilder builder) {
		
        boolean flag = doctorService.createDoctor(MDoctor);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/doctor?id={id}").buildAndExpand(MDoctor.getDoctorId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateMDoctor
	@PutMapping("doctor")
	public ResponseEntity<MDoctor> updateMDoctor(@RequestBody MDoctor MDoctor) {
		doctorService.updateDoctor(MDoctor);
		return new ResponseEntity<MDoctor>(MDoctor, HttpStatus.OK);
	}
	
	//deleteMDoctor
	@DeleteMapping("doctor")
	public ResponseEntity<Void> deleteMDoctor(@RequestParam("id") BigDecimal id) {
		doctorService.deleteDoctor(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 