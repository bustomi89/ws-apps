package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TTreatment;

public interface ITreatmentService {
	
	 TTreatment getTreatmentById(BigDecimal treatmentId);
	 
	 List<TTreatment> getAllTreatment();
     
     boolean createTreatment(TTreatment treatment);
     
     void updateTreatment(TTreatment treatment);
     
     void deleteTreatment(BigDecimal treatmentId);
}
