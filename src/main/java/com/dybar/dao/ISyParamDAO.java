package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.SyParameterlist;;

public interface ISyParamDAO {
    List<SyParameterlist> getAllSyParams();
    SyParameterlist getSyParamById(BigDecimal SyParamId);
//    void createSyParam(SyParameterlist SyParam);
//    void updateSyParam(SyParameterlist SyParam);
//    void deleteSyParam(BigDecimal SyParamId);
    
    boolean SyParamExists(BigDecimal SyParamId, String SyParamCode);
    
}
 