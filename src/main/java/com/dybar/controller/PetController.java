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

import com.dybar.entity.TPet;
import com.dybar.service.IPetService;

@Controller
@RequestMapping("pet")
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = {"*"})
public class PetController {
	
	@Autowired
	private IPetService petService;
	
	//getTPetById
	@GetMapping("pet")
	public ResponseEntity<TPet> getTPetById(@RequestParam("id") BigDecimal id) {
		TPet TPet = petService.getPetById(id);
		return new ResponseEntity<TPet>(TPet, HttpStatus.OK);
	}
	
	//getAllTPet
	@GetMapping("all-pet")
	public ResponseEntity<List<TPet>> getAllTPet() {
		List<TPet> list = petService.getAllPet();
		return new ResponseEntity<List<TPet>>(list, HttpStatus.OK);
	}
	
	//createTPet
	@PostMapping("pet")
	public ResponseEntity<Void> createTPet(@RequestBody TPet TPet, UriComponentsBuilder builder) {
		
        boolean flag = petService.createPet(TPet);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/pet?id={id}").buildAndExpand(TPet.getPetId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateTPet
	@PutMapping("pet")
	public ResponseEntity<TPet> updateTPet(@RequestBody TPet TPet) {
		petService.updatePet(TPet);
		return new ResponseEntity<TPet>(TPet, HttpStatus.OK);
	}
	
	//deleteTPet
	@DeleteMapping("pet")
	public ResponseEntity<Void> deleteTPet(@RequestParam("id") BigDecimal id) {
		petService.deletePet(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 