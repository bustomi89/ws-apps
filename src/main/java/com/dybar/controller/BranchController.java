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

import com.dybar.entity.MBranch;
import com.dybar.service.IBranchService;

@Controller
@RequestMapping("branch")
@CrossOrigin(origins = {"*"})
public class BranchController {
	
	@Autowired
	private IBranchService branchService;
	

	//getMbranchById
	@GetMapping("branch")
	public ResponseEntity<MBranch> getMbranchById(@RequestParam("id") BigDecimal id) {
		MBranch Mbranch = branchService.getBranchById(id);
		return new ResponseEntity<MBranch>(Mbranch, HttpStatus.OK);
	}
	
	//getAllMbranchs
	@GetMapping("all-branchs")
	public ResponseEntity<List<MBranch>> getAllMbranchs() {
		List<MBranch> list = branchService.getAllBranchs();
		return new ResponseEntity<List<MBranch>>(list, HttpStatus.OK);
	}
	
	//createMbranch
	@PostMapping("branch")
	public ResponseEntity<Void> createMbranch(@RequestBody MBranch Mbranch, UriComponentsBuilder builder) {
		
        boolean flag = branchService.createBranch(Mbranch);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/branch?id={id}").buildAndExpand(Mbranch.getBranchId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateMbranch
	@PutMapping("branch")
	public ResponseEntity<MBranch> updateMbranch(@RequestBody MBranch Mbranch) {
		branchService.updateBranch(Mbranch);
		return new ResponseEntity<MBranch>(Mbranch, HttpStatus.OK);
	}
	
	//deleteMbranch
	@DeleteMapping("branch")
	public ResponseEntity<Void> deleteMbranch(@RequestParam("id") BigDecimal id) {
		branchService.deleteBranch(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	

}
