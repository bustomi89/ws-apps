package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ITExaminationDetailDAO;
import com.dybar.entity.TExaminationDetail;
@Service
public class TExaminationDetailService implements ITExaminationDetailService {

	@Autowired
	private ITExaminationDetailDAO ExaminationDAO;

	@Override
	public TExaminationDetail getExaminationDetailById(BigDecimal ExaminationDetailId) {
		TExaminationDetail obj = ExaminationDAO.getExaminationDetailById(ExaminationDetailId);
		return obj;
	}
	
	@Override
	public List<TExaminationDetail> getAllExaminationDetails() {
		// TODO Auto-generated method stub
		return ExaminationDAO.getAllExaminationDetails();
	}


	@Override
	public boolean createExaminationDetail(TExaminationDetail ExaminationDetail) {
	       if (ExaminationDAO.ExaminationDetailExists(ExaminationDetail.getExamDetailId())) {
	    	   return false;
	       } else {
	    	   ExaminationDAO.createExaminationDetail(ExaminationDetail);
	    	   return true;
	       }
	}

	@Override
	public void updateExaminationDetail(TExaminationDetail ExaminationDetail) {
		ExaminationDAO.updateExaminationDetail(ExaminationDetail);
		
	}

	@Override
	public void deleteExaminationDetail(BigDecimal ExaminationDetailId) {
		ExaminationDAO.deleteExaminationDetail(ExaminationDetailId);
	}

}
