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

import com.dybar.entity.TExamination;
import com.dybar.service.TExaminationService;

@Controller
@RequestMapping("transaction")
@CrossOrigin(origins = {"*"})
public class TExaminationController {
	
	@Autowired
	private TExaminationService examinationService;
	
	//get MExaminationById
	@GetMapping("examination")
	public ResponseEntity<TExamination> getMExaminationById(@RequestParam("id") BigDecimal id) {
		TExamination mExamination = examinationService.getExaminationById(id);
		return new ResponseEntity<TExamination>(mExamination, HttpStatus.OK);
	}
	
	//getAll MExaminations
	@GetMapping("all-examinations")
	public ResponseEntity<List<TExamination>> getAllMExaminations() {
		List<TExamination> list = examinationService.getAllExaminations();
		return new ResponseEntity<List<TExamination>>(list, HttpStatus.OK);
	}
	
	//create MExamination
	@PostMapping("examination")
	public ResponseEntity<Void> createMExamination(@RequestBody TExamination tExamination, UriComponentsBuilder builder) {
		
        boolean flag = examinationService.createExamination(tExamination);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/examination?id={id}").buildAndExpand(tExamination.getExamId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//update MExamination
	@PutMapping("examination")
	public ResponseEntity<TExamination> updateMExamination(@RequestBody TExamination MExamination) {
		examinationService.updateExamination(MExamination);
		return new ResponseEntity<TExamination>(MExamination, HttpStatus.OK);
	}
	
	//delete MExamination
	@DeleteMapping("examination")
	public ResponseEntity<Void> deleteMExamination(@RequestParam("id") BigDecimal id) {
		examinationService.deleteExamination(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 