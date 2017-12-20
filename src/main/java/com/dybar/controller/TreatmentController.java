package com.dybar.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.dybar.entity.TTreatmentDetail;
import com.dybar.response.HospitalResponse;
import com.dybar.service.ITTreatmentDetailService;
import com.dybar.service.ITreatmentService;

@Controller
@RequestMapping("hospital")
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = {"*"})
public class TreatmentController {
	
	@Autowired
	private ITreatmentService hospitalService;
	
	@Autowired
	private ITTreatmentDetailService hospitalDetailService;
	
	//getTTreatmentById
	@GetMapping("hospital")
	public ResponseEntity<HospitalResponse> getTTreatmentById(@RequestParam("id") BigDecimal id) {
		TTreatment tTreatment = hospitalService.getTreatmentById(id);
		List<TTreatmentDetail> listDetail = hospitalDetailService.getTreatmentDetailByTreatmentId(id);
		HospitalResponse response = new HospitalResponse(tTreatment, listDetail);
		return new ResponseEntity<HospitalResponse>(response, HttpStatus.OK);
	}
	
	//getAllTTreatment
	@GetMapping("all-hospital")
	public ResponseEntity<List> getAllTTreatment() {
		List<TTreatment> list = hospitalService.getAllTreatment();
		List<TTreatmentDetail> listDetail = new ArrayList<TTreatmentDetail>();
		List<HospitalResponse> listHospitalResponse = new ArrayList<HospitalResponse>();
//		HospitalResponse hospitalResponse = null;
		
		for (TTreatment tTreatment : list) {
			listDetail = hospitalDetailService.getTreatmentDetailByTreatmentId(tTreatment.getTreatmentId());
			HospitalResponse hospitalResponse = new HospitalResponse(tTreatment,listDetail);
			listHospitalResponse.add(hospitalResponse);
		}
		return new ResponseEntity<List>(listHospitalResponse, HttpStatus.OK);
	}
	
	//createTTreatment
	@PostMapping("hospital")
	public ResponseEntity<Void> createTTreatment(@RequestBody HospitalResponse hospitalResponse, UriComponentsBuilder builder) {
		TTreatment tTreatment = hospitalResponse.getTTreatment();
        tTreatment = hospitalService.createTreatment(tTreatment);
        boolean flag = true;
        List<TTreatmentDetail> listTreatmentDetail = new ArrayList<TTreatmentDetail>(); 
        		listTreatmentDetail = hospitalResponse.getTreatmentDetail();
        for (TTreatmentDetail tTreatmentDetail : listTreatmentDetail) {
        	tTreatmentDetail.setTreatmentId(tTreatment.getTreatmentId());
        	flag = hospitalDetailService.createTreatmentDetail(tTreatmentDetail);
		}
//        
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/hospital?id={id}").buildAndExpand(tTreatment.getTreatmentId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateTTreatment
	@PutMapping("hospital")
	public ResponseEntity<HospitalResponse> updateTTreatment(@RequestBody HospitalResponse hospitalResponse) {
		TTreatment tTreatment = hospitalResponse.getTTreatment();
		hospitalService.updateTreatment(tTreatment);
		List<TTreatmentDetail> listTreatmentDetail = new ArrayList<TTreatmentDetail>();
		listTreatmentDetail = hospitalResponse.getTreatmentDetail();
		
		for (TTreatmentDetail tTreatmentDetail : listTreatmentDetail) {
			if (tTreatmentDetail.getTreatmentDetailId() == null) {
				hospitalDetailService.createTreatmentDetail(tTreatmentDetail);
			} else {
				hospitalDetailService.updateTreatmentDetail(tTreatmentDetail);
			}
		}
		
		return new ResponseEntity<HospitalResponse>(hospitalResponse, HttpStatus.OK);
	}
	
	//deleteTTreatment
	@DeleteMapping("hospital")
	public ResponseEntity<Void> deleteTTreatment(@RequestParam("id") BigDecimal id) {
		hospitalService.deleteTreatment(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 