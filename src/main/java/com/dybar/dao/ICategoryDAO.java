package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MCategory;;

public interface ICategoryDAO {
    List<MCategory> getAllCategorys();
    MCategory getCategoryById(BigDecimal CategoryId);
    void createCategory(MCategory Category);
    void updateCategory(MCategory Category);
    void deleteCategory(BigDecimal CategoryId);
    
    boolean CategoryExists(BigDecimal CategoryId, String CategoryCode);
    
}
 