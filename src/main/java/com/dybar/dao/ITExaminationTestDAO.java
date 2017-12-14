package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.TExaminationTest;

public interface ITExaminationTestDAO {
    List<TExaminationTest> getAllExaminationTests();
    
    TExaminationTest getExaminationTestById(BigDecimal TestId);
    
    void createExaminationTest(TExaminationTest ExaminationTest);
    void updateExaminationTest(TExaminationTest ExaminationTest);
    void deleteExaminationTest(BigDecimal TestId);
    
    boolean ExaminationTestExists(BigDecimal TestId);
    
}
 