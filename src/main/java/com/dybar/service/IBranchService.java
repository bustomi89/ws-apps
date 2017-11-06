package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import com.dybar.entity.MBranch;

public interface IBranchService {
	
	 MBranch getBranchById(BigDecimal branchId);
	 
	 List<MBranch> getAllBranchs();
     
     boolean createBranch(MBranch branch);
     
     void updateBranch(MBranch branch);
     
     void deleteBranch(BigDecimal branchId);
}
