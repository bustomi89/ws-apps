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

import com.dybar.entity.TTreatmentDetail;
import com.dybar.service.TTreatmentDetailService;

@Controller
@RequestMapping("treatment")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TTreatmentDetailController {
	
	@Autowired
	private TTreatmentDetailService TreatmentService;
	
	//get MTreatmentById
	@GetMapping("treatment-detail")
	public ResponseEntity<TTreatmentDetail> getMTreatmentById(@RequestParam("id") BigDecimal id) {
		TTreatmentDetail mTreatment = TreatmentService.getTreatmentDetailById(id);
		return new ResponseEntity<TTreatmentDetail>(mTreatment, HttpStatus.OK);
	}
	
	//getAll MTreatments
	@GetMapping("all-treatment-detail")
	public ResponseEntity<List<TTreatmentDetail>> getAllMTreatments() {
		List<TTreatmentDetail> list = TreatmentService.getAllTreatmentDetails();
		return new ResponseEntity<List<TTreatmentDetail>>(list, HttpStatus.OK);
	}
	
	//create MTreatment
	@PostMapping("treatment-detail")
	public ResponseEntity<Void> createMTreatment(@RequestBody TTreatmentDetail TTreatmentDetail, UriComponentsBuilder builder) {
		
        boolean flag = TreatmentService.createTreatmentDetail(TTreatmentDetail);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/treatment-detail?id={id}").buildAndExpand(TTreatmentDetail.getTreatmentDetailId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//update MTreatment
	@PutMapping("treatment-detail")
	public ResponseEntity<TTreatmentDetail> updateMTreatment(@RequestBody TTreatmentDetail MTreatment) {
		TreatmentService.updateTreatmentDetail(MTreatment);
		return new ResponseEntity<TTreatmentDetail>(MTreatment, HttpStatus.OK);
	}
	
	//delete MTreatment
	@DeleteMapping("treatment-detail")
	public ResponseEntity<Void> deleteMTreatment(@RequestParam("id") BigDecimal id) {
		TreatmentService.deleteTreatmentDetail(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 