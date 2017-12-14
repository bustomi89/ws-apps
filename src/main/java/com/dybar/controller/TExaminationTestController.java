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

import com.dybar.entity.TExaminationTest;
import com.dybar.service.TExaminationTestService;

@Controller
@RequestMapping("exam-test")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TExaminationTestController {
	
	@Autowired
	private TExaminationTestService examinationService;
	
	//get MExaminationById
	@GetMapping("examination-test")
	public ResponseEntity<TExaminationTest> getMExaminationById(@RequestParam("id") BigDecimal id) {
		TExaminationTest mExamination = examinationService.getExaminationTestById(id);
		return new ResponseEntity<TExaminationTest>(mExamination, HttpStatus.OK);
	}
	
	//getAll MExaminations
	@GetMapping("all-examinations-test")
	public ResponseEntity<List<TExaminationTest>> getAllMExaminations() {
		List<TExaminationTest> list = examinationService.getAllExaminationTests();
		return new ResponseEntity<List<TExaminationTest>>(list, HttpStatus.OK);
	}
	
	//create MExamination
	@PostMapping("examination-test")
	public ResponseEntity<Void> createMExamination(@RequestBody TExaminationTest TExaminationTest, UriComponentsBuilder builder) {
		
        boolean flag = examinationService.createExaminationTest(TExaminationTest);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/examination-test?id={id}").buildAndExpand(TExaminationTest.getExamId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//update MExamination
	@PutMapping("examination-test")
	public ResponseEntity<TExaminationTest> updateMExamination(@RequestBody TExaminationTest MExamination) {
		examinationService.updateExaminationTest(MExamination);
		return new ResponseEntity<TExaminationTest>(MExamination, HttpStatus.OK);
	}
	
	//delete MExamination
	@DeleteMapping("examination-test")
	public ResponseEntity<Void> deleteMExamination(@RequestParam("id") BigDecimal id) {
		examinationService.deleteExaminationTest(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 