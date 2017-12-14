package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExamination;

public interface ITExaminationDAO {
    List<TExamination> getAllExaminations();
    TExamination getExaminationById(BigDecimal ExaminationId);
    void createExamination(TExamination Examination);
    void updateExamination(TExamination Examination);
    void deleteExamination(BigDecimal ExaminationId);
    
    boolean ExaminationExists(BigDecimal ExaminationId);
    
}
 