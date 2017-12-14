package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExaminationTest;

public interface ITExaminationTestService {
	
	TExaminationTest getExaminationTestById(BigDecimal TestId);
	 
	 List<TExaminationTest> getAllExaminationTests();
     
     boolean createExaminationTest(TExaminationTest ExaminationTest);
     
     void updateExaminationTest(TExaminationTest ExaminationTest);
     
     void deleteExaminationTest(BigDecimal TestId);
}
