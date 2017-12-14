package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ITExaminationTestDAO;
import com.dybar.entity.TExaminationTest;
@Service
public class TExaminationTestService implements ITExaminationTestService {

	@Autowired
	private ITExaminationTestDAO ExaminationTestDAO;

	@Override
	public TExaminationTest getExaminationTestById(BigDecimal TestId) {
		TExaminationTest obj = ExaminationTestDAO.getExaminationTestById(TestId);
		return obj;
	}
	
	@Override
	public List<TExaminationTest> getAllExaminationTests() {
		// TODO Auto-generated method stub
		return ExaminationTestDAO.getAllExaminationTests();
	}


	@Override
	public boolean createExaminationTest(TExaminationTest ExaminationTest) {
	       if (ExaminationTestDAO.ExaminationTestExists(ExaminationTest.getTestId())) {
	    	   return false;
	       } else {
	    	   ExaminationTestDAO.createExaminationTest(ExaminationTest);
	    	   return true;
	       }
	}

	@Override
	public void updateExaminationTest(TExaminationTest Examination) {
		ExaminationTestDAO.updateExaminationTest(Examination);
		
	}

	@Override
	public void deleteExaminationTest(BigDecimal ExaminationId) {
		ExaminationTestDAO.deleteExaminationTest(ExaminationId);
	}

}
