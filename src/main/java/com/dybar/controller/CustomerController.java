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

import com.dybar.entity.TCustomer;
import com.dybar.service.ICustomerService;

@Controller
@RequestMapping("customer")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	//getTCustomerById
	@GetMapping("customer")
	public ResponseEntity<TCustomer> getTCustomerById(@RequestParam("id") BigDecimal id) {
		TCustomer TCustomer = customerService.getCustomerById(id);
		return new ResponseEntity<TCustomer>(TCustomer, HttpStatus.OK);
	}
	
	//getAllTCustomer
	@GetMapping("all-customer")
	public ResponseEntity<List<TCustomer>> getAllTCustomer() {
		List<TCustomer> list = customerService.getAllCustomer();
		return new ResponseEntity<List<TCustomer>>(list, HttpStatus.OK);
	}
	
	//createTCustomer
	@PostMapping("customer")
	public ResponseEntity<Void> createTCustomer(@RequestBody TCustomer TCustomer, UriComponentsBuilder builder) {
		
        boolean flag = customerService.createCustomer(TCustomer);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/customer?id={id}").buildAndExpand(TCustomer.getCustomerId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateTCustomer
	@PutMapping("customer")
	public ResponseEntity<TCustomer> updateTCustomer(@RequestBody TCustomer TCustomer) {
		customerService.updateCustomer(TCustomer);
		return new ResponseEntity<TCustomer>(TCustomer, HttpStatus.OK);
	}
	
	//deleteTCustomer
	@DeleteMapping("customer")
	public ResponseEntity<Void> deleteTCustomer(@RequestParam("id") BigDecimal id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 