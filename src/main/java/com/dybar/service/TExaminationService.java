package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ITExaminationDAO;
import com.dybar.entity.TExamination;
@Service
public class TExaminationService implements ITExaminationService {

	@Autowired
	private ITExaminationDAO ExaminationDAO;

	@Override
	public TExamination getExaminationById(BigDecimal ExaminationId) {
		TExamination obj = ExaminationDAO.getExaminationById(ExaminationId);
		return obj;
	}
	
	@Override
	public List<TExamination> getAllExaminations() {
		// TODO Auto-generated method stub
		return ExaminationDAO.getAllExaminations();
	}


	@Override
	public boolean createExamination(TExamination Examination) {
	       if (ExaminationDAO.ExaminationExists(Examination.getExamId())) {
	    	   return false;
	       } else {
	    	   ExaminationDAO.createExamination(Examination);
	    	   return true;
	       }
	}

	@Override
	public void updateExamination(TExamination Examination) {
		ExaminationDAO.updateExamination(Examination);
		
	}

	@Override
	public void deleteExamination(BigDecimal ExaminationId) {
		ExaminationDAO.deleteExamination(ExaminationId);
	}

}
