package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExaminationDetail;

public interface ITExaminationDetailService {
	
	TExaminationDetail getExaminationDetailById(BigDecimal ExaminationDetailId);
	 
	 List<TExaminationDetail> getAllExaminationDetails();
     
     boolean createExaminationDetail(TExaminationDetail ExaminationDetail);
     
     void updateExaminationDetail(TExaminationDetail ExaminationDetail);
     
     void deleteExaminationDetail(BigDecimal ExaminationDetailId);
}
