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

import com.dybar.entity.TTreatment;
import com.dybar.service.ITreatmentService;

@Controller
@RequestMapping("hospital")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TreatmentController {
	
	@Autowired
	private ITreatmentService hospitalService;
	
	//getTTreatmentById
	@GetMapping("hospital")
	public ResponseEntity<TTreatment> getTTreatmentById(@RequestParam("id") BigDecimal id) {
		TTreatment TTreatment = hospitalService.getTreatmentById(id);
		return new ResponseEntity<TTreatment>(TTreatment, HttpStatus.OK);
	}
	
	//getAllTTreatment
	@GetMapping("all-hospital")
	public ResponseEntity<List<TTreatment>> getAllTTreatment() {
		List<TTreatment> list = hospitalService.getAllTreatment();
		return new ResponseEntity<List<TTreatment>>(list, HttpStatus.OK);
	}
	
	//createTTreatment
	@PostMapping("hospital")
	public ResponseEntity<Void> createTTreatment(@RequestBody TTreatment TTreatment, UriComponentsBuilder builder) {
		
        boolean flag = hospitalService.createTreatment(TTreatment);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/hospital?id={id}").buildAndExpand(TTreatment.getTreatmentId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateTTreatment
	@PutMapping("hospital")
	public ResponseEntity<TTreatment> updateTTreatment(@RequestBody TTreatment TTreatment) {
		hospitalService.updateTreatment(TTreatment);
		return new ResponseEntity<TTreatment>(TTreatment, HttpStatus.OK);
	}
	
	//deleteTTreatment
	@DeleteMapping("hospital")
	public ResponseEntity<Void> deleteTTreatment(@RequestParam("id") BigDecimal id) {
		hospitalService.deleteTreatment(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 