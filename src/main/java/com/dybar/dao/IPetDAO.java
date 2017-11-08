package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TPet;;

public interface IPetDAO {
    List<TPet> getAllPet();
    TPet getPetById(BigDecimal PetId);
    void createPet(TPet Pet);
    void updatePet(TPet Pet);
    void deletePet(BigDecimal PetId);
    
    boolean PetExists(BigDecimal PetId);
    
}
 