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

import com.dybar.entity.MCategory;
import com.dybar.service.ICategoryService;

@Controller
@RequestMapping("category")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	//getMCategoryById
	@GetMapping("category")
	public ResponseEntity<MCategory> getMCategoryById(@RequestParam("id") BigDecimal id) {
		MCategory MCategory = categoryService.getCategoryById(id);
		return new ResponseEntity<MCategory>(MCategory, HttpStatus.OK);
	}
	
	//getAllMCategorys
	@GetMapping("all-categorys")
	public ResponseEntity<List<MCategory>> getAllMCategorys() {
		List<MCategory> list = categoryService.getAllCategorys();
		return new ResponseEntity<List<MCategory>>(list, HttpStatus.OK);
	}
	
	//createMCategory
	@PostMapping("category")
	public ResponseEntity<Void> createMCategory(@RequestBody MCategory MCategory, UriComponentsBuilder builder) {
		
        boolean flag = categoryService.createCategory(MCategory);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(builder.path("/category?id={id}").buildAndExpand(MCategory.getCategoryId()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//updateMCategory
	@PutMapping("category")
	public ResponseEntity<MCategory> updateMCategory(@RequestBody MCategory MCategory) {
		categoryService.updateCategory(MCategory);
		return new ResponseEntity<MCategory>(MCategory, HttpStatus.OK);
	}
	
	//deleteMCategory
	@DeleteMapping("category")
	public ResponseEntity<Void> deleteMCategory(@RequestParam("id") BigDecimal id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	
} 