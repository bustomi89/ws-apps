package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MCategory;

public interface ICategoryService {
	
	 MCategory getCategoryById(BigDecimal categoryId);
	 
	 List<MCategory> getAllCategorys();
     
     boolean createCategory(MCategory category);
     
     void updateCategory(MCategory category);
     
     void deleteCategory(BigDecimal categoryId);
}
