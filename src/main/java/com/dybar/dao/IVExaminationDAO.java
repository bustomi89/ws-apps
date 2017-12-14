package com.dybar.dao;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.VExamination;

public interface IVExaminationDAO {
	   List<VExamination> getAllExaminations();
	   VExamination getExaminationById(BigDecimal ExaminationId);    
	    boolean ExaminationExists(BigDecimal ExaminationId);
}
