package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MBranch;

public interface IBranchDAO {
    List<MBranch> getAllBranchs();
    MBranch getBranchById(BigDecimal BranchId);
    void createBranch(MBranch Branch);
    void updateBranch(MBranch Branch);
    void deleteBranch(BigDecimal BranchId);
    
    boolean BranchExists(BigDecimal BranchId, String BranchCode);
    
}
 