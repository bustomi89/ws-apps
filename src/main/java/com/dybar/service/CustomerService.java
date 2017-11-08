package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ICustomerDAO;
import com.dybar.entity.TCustomer;
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public TCustomer getCustomerById(BigDecimal CustomerId) {
		TCustomer obj = customerDAO.getCustomerById(CustomerId);
		return obj;
	}
	
	@Override
	public List<TCustomer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerDAO.getAllCustomer();
	}


	@Override
	public boolean createCustomer(TCustomer customer) {
	       if (customerDAO.CustomerExists(customer.getCustomerId())) {
	    	   return false;
	       } else {
	    	   customerDAO.createCustomer(customer);
	    	   return true;
	       }
	}

	@Override
	public void updateCustomer(TCustomer customer) {
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(BigDecimal customerId) {
		customerDAO.deleteCustomer(customerId);
	}

}
