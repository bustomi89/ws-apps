package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExamination;

public interface ITExaminationService {
	
	TExamination getExaminationById(BigDecimal ExaminationId);
	 
	 List<TExamination> getAllExaminations();
     
     boolean createExamination(TExamination Examination);
     
     void updateExamination(TExamination Examination);
     
     void deleteExamination(BigDecimal ExaminationId);
}
