package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TTreatmentDetail;

public interface ITTreatmentDetailService {
	
	TTreatmentDetail getTreatmentDetailById(BigDecimal TreatmentDetailId);
	 
	 List<TTreatmentDetail> getAllTreatmentDetails();
     
     boolean createTreatmentDetail(TTreatmentDetail TreatmentDetail);
     
     void updateTreatmentDetail(TTreatmentDetail TreatmentDetail);
     
     void deleteTreatmentDetail(BigDecimal TreatmentDetailId);

	List<TTreatmentDetail> getTreatmentDetailByTreatmentId(BigDecimal TreatmentId);
}
