package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TTreatmentDetail;

public interface ITTreatmentDetailDAO {
    List<TTreatmentDetail> getAllTreatmentDetails();
    TTreatmentDetail getTreatmentDetailById(BigDecimal TreatmentDetailId);
    List<TTreatmentDetail> getTreatmentDetailByTreatmentId(BigDecimal TreatmentId);
    
    void createTreatmentDetail(TTreatmentDetail TreatmentDetail);
    void updateTreatmentDetail(TTreatmentDetail TreatmentDetail);
    void deleteTreatmentDetail(BigDecimal TreatmentDetailId);
    
    boolean TreatmentDetailExists(BigDecimal TreatmentDetailId);
    
}
 