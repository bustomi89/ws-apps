package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TPet;
import com.dybar.entity.TTreatment;;

public interface ITreatmentDAO {
    List<TTreatment> getAllTreatment();
    TTreatment getTreatmentById(BigDecimal TreatmentId);
    void createTreatment(TTreatment Treatment);
    void updateTreatment(TTreatment Treatment);
    void deleteTreatment(BigDecimal TreatmentId);
    
    boolean TreatmentExists(BigDecimal TreatmentId);
    
}
 