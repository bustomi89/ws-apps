package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MDoctor;

public interface IDoctorService {
	
	 MDoctor getDoctorById(BigDecimal doctorId);
	 
	 List<MDoctor> getAllDoctor();
     
     boolean createDoctor(MDoctor doctor);
     
     void updateDoctor(MDoctor doctor);
     
     void deleteDoctor(BigDecimal doctorId);
}
