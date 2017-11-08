package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TCustomer;

public interface ICustomerService {
	
	 TCustomer getCustomerById(BigDecimal customerId);
	 
	 List<TCustomer> getAllCustomer();
     
     boolean createCustomer(TCustomer customer);
     
     void updateCustomer(TCustomer customer);
     
     void deleteCustomer(BigDecimal customerId);
}
