package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TCustomer;;

public interface ICustomerDAO {
    List<TCustomer> getAllCustomer();
    TCustomer getCustomerById(BigDecimal CustomerId);
    void createCustomer(TCustomer Customer);
    void updateCustomer(TCustomer Customer);
    void deleteCustomer(BigDecimal CustomerId);
    
    boolean CustomerExists(BigDecimal CustomerId);
    
}
 