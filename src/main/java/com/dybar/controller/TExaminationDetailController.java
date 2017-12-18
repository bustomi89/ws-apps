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

import com.dybar.entity.TExaminationDetail;
import com.dybar.service.TExaminationDetailService;

@Controller
@RequestMapping("exam-detail")
@CrossOrigin(origins = {"*"})
public class TExaminationDetailController {
	
	@Autowired
	private TExaminationDetailService examinationService;
	
	//get MExaminationById
	@GetMapping("examination-detail")
	public ResponseEntity<TExaminationDetail> getMExaminationById(@RequestParam("id") BigDecimal id) {
		TExaminationDetail mExamination = examinationService.getExaminationDetailById(id);
		return new ResponseEntity<TExaminationDetail>(mExamination, HttpStatus.OK);
	}
	
	//getAll MExaminations
	@GetMapping("all-examinations-detail")
	public ResponseEntity<List<TExaminationDetail>> getAllMExaminations() {
		List<TExaminationDetail> list = examinationService.getAllExaminationDetails();
		return new ResponseEntity<List<TExaminationDetail>>(list, HttpStatus.OK);
	}
	
	//create MExamination
	@PostMapping("examination-detail")
	public ResponseEntity<Void> createMExamination(@RequestBody TExaminationDetail TExaminationDetail, UriComponentsBuilder builder) {
		
        boolean flag = examinationService.createExaminationDetail(TExaminationDetail);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/examination-detail?id={id}").buildAndExpand(TExaminationDetail.getExamDetailId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//update MExamination
	@PutMapping("examination-detail")
	public ResponseEntity<TExaminationDetail> updateMExamination(@RequestBody TExaminationDetail MExamination) {
		examinationService.updateExaminationDetail(MExamination);
		return new ResponseEntity<TExaminationDetail>(MExamination, HttpStatus.OK);
	}
	
	//delete MExamination
	@DeleteMapping("examination-detail")
	public ResponseEntity<Void> deleteMExamination(@RequestParam("id") BigDecimal id) {
		examinationService.deleteExaminationDetail(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 