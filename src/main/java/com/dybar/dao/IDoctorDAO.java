package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MDoctor;;

public interface IDoctorDAO {
    List<MDoctor> getAllDoctor();
    MDoctor getDoctorById(BigDecimal DoctorId);
    void createDoctor(MDoctor Doctor);
    void updateDoctor(MDoctor Doctor);
    void deleteDoctor(BigDecimal DoctorId);
    
    boolean DoctorExists(BigDecimal DoctorId, String DoctorCode);
    
}
 