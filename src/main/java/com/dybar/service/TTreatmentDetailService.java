package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ITTreatmentDetailDAO;
import com.dybar.entity.TTreatmentDetail;
@Service
public class TTreatmentDetailService implements ITTreatmentDetailService {

	@Autowired
	private ITTreatmentDetailDAO TreatmentDAO;

	@Override
	public TTreatmentDetail getTreatmentDetailById(BigDecimal TreatmentDetailId) {
		TTreatmentDetail obj = TreatmentDAO.getTreatmentDetailById(TreatmentDetailId);
		return obj;
	}
	
	@Override
	public List<TTreatmentDetail> getAllTreatmentDetails() {
		// TODO Auto-generated method stub
		return TreatmentDAO.getAllTreatmentDetails();
	}


	@Override
	public boolean createTreatmentDetail(TTreatmentDetail TreatmentDetail) {
	       if (TreatmentDAO.TreatmentDetailExists(TreatmentDetail.getTreatmentDetailId())) {
	    	   return false;
	       } else {
	    	   TreatmentDAO.createTreatmentDetail(TreatmentDetail);
	    	   return true;
	       }
	}

	@Override
	public void updateTreatmentDetail(TTreatmentDetail TreatmentDetail) {
		TreatmentDAO.updateTreatmentDetail(TreatmentDetail);
		
	}

	@Override
	public void deleteTreatmentDetail(BigDecimal TreatmentDetailId) {
		TreatmentDAO.deleteTreatmentDetail(TreatmentDetailId);
	}

}
