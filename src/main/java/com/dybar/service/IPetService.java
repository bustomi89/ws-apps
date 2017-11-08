package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TPet;

public interface IPetService {
	
	 TPet getPetById(BigDecimal petId);
	 
	 List<TPet> getAllPet();
     
     boolean createPet(TPet pet);
     
     void updatePet(TPet pet);
     
     void deletePet(BigDecimal petId);
}
