package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ITreatmentDAO;
import com.dybar.entity.TTreatment;
@Service
public class TreatmentService implements ITreatmentService{

	@Autowired
	private ITreatmentDAO treatmentDAO;

	@Override
	public TTreatment getTreatmentById(BigDecimal treatmentId) {
		TTreatment obj = treatmentDAO.getTreatmentById(treatmentId);
		return obj;
	}
	
	@Override
	public List<TTreatment> getAllTreatment() {
		// TODO Auto-generated method stub
		return treatmentDAO.getAllTreatment();
	}


	@Override
	public TTreatment createTreatment(TTreatment treatment) {
	       if (treatmentDAO.TreatmentExists(treatment.getTreatmentId())) {
	    	   return treatment;
	       } else {
//	    	   treatmentDAO.createTreatment(treatment);
	    	   return treatmentDAO.createTreatment(treatment);
	       }
	}

	@Override
	public void updateTreatment(TTreatment treatment) {
		treatmentDAO.updateTreatment(treatment);
		
	}

	@Override
	public void deleteTreatment(BigDecimal treatmentId) {
		treatmentDAO.deleteTreatment(treatmentId);
	}

}
