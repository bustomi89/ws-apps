package com.dybar.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dybar.entity.VExamination;
import com.dybar.service.VExaminationService;

@Controller
@RequestMapping("vtransaction")
@CrossOrigin(origins = {"*"})
public class VExaminationController {
	
	@Autowired
	private VExaminationService examinationService;
	
	//get MExaminationById
	@GetMapping("examination")
	public ResponseEntity<VExamination> getMExaminationById(@RequestParam("id") BigDecimal id) {
		VExamination mExamination = examinationService.getExaminationById(id);
		return new ResponseEntity<VExamination>(mExamination, HttpStatus.OK);
	}
	
	//getAll MExaminations
	@GetMapping("all-examinations")
	public ResponseEntity<List<VExamination>> getAllMExaminations() {
		List<VExamination> list = examinationService.getAllExaminations();
		return new ResponseEntity<List<VExamination>>(list, HttpStatus.OK);
	}
	
} 