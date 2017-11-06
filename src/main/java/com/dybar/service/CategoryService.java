package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ICategoryDAO;
import com.dybar.entity.MCategory;
@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public MCategory getCategoryById(BigDecimal CategoryId) {
		MCategory obj = categoryDAO.getCategoryById(CategoryId);
		return obj;
	}
	
	@Override
	public List<MCategory> getAllCategorys() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategorys();
	}


	@Override
	public boolean createCategory(MCategory category) {
	       if (categoryDAO.CategoryExists(category.getCategoryId(), category.getCategoryCode())) {
	    	   return false;
	       } else {
	    	   categoryDAO.createCategory(category);
	    	   return true;
	       }
	}

	@Override
	public void updateCategory(MCategory category) {
		categoryDAO.updateCategory(category);
		
	}

	@Override
	public void deleteCategory(BigDecimal categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}

}
