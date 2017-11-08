package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.ICategoryDAO;
import com.dybar.dao.IDoctorDAO;
import com.dybar.entity.MCategory;
import com.dybar.entity.MDoctor;
@Service
public class DoctorService implements IDoctorService{

	@Autowired
	private IDoctorDAO doctorDAO;

	@Override
	public MDoctor getDoctorById(BigDecimal DoctorId) {
		MDoctor obj = doctorDAO.getDoctorById(DoctorId);
		return obj;
	}
	
	@Override
	public List<MDoctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorDAO.getAllDoctor();
	}


	@Override
	public boolean createDoctor(MDoctor doctor) {
	       if (doctorDAO.DoctorExists(doctor.getDoctorId(), doctor.getDoctorCode())) {
	    	   return false;
	       } else {
	    	   doctorDAO.createDoctor(doctor);
	    	   return true;
	       }
	}

	@Override
	public void updateDoctor(MDoctor doctor) {
		doctorDAO.updateDoctor(doctor);
		
	}

	@Override
	public void deleteDoctor(BigDecimal doctorId) {
		doctorDAO.deleteDoctor(doctorId);
	}

}
