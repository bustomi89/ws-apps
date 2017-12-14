package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExaminationDetail;

public interface ITExaminationDetailDAO {
    List<TExaminationDetail> getAllExaminationDetails();
    TExaminationDetail getExaminationDetailById(BigDecimal ExaminationDetailId);
    void createExaminationDetail(TExaminationDetail ExaminationDetail);
    void updateExaminationDetail(TExaminationDetail ExaminationDetail);
    void deleteExaminationDetail(BigDecimal ExaminationDetailId);
    
    boolean ExaminationDetailExists(BigDecimal ExaminationDetailId);
    
}
 