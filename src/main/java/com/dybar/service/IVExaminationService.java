package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.VExamination;

public interface IVExaminationService {
	
	VExamination getExaminationById(BigDecimal ExaminationId);
	 
	 List<VExamination> getAllExaminations();
    
}
