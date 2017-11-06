package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.IBranchDAO;
import com.dybar.entity.MBranch;
@Service
public class BranchService implements IBranchService{

	@Autowired
	private IBranchDAO branchDAO;
	
	@Override
	public MBranch getBranchById(BigDecimal branchId) {
		// TODO Auto-generated method stub
		MBranch obj = branchDAO.getBranchById(branchId);
		return obj;
	}

	@Override
	public List<MBranch> getAllBranchs() {
		// TODO Auto-generated method stub
		return branchDAO.getAllBranchs();
	}

	@Override
	public boolean createBranch(MBranch branch) {
		// TODO Auto-generated method stub
		 if (branchDAO.BranchExists(branch.getBranchId(), branch.getBranchCode())) {
	    	   return false;
	       } else {
	    	   branchDAO.createBranch(branch);
	    	   return true;
	       }
	}

	@Override
	public void updateBranch(MBranch branch) {
		// TODO Auto-generated method stub
		branchDAO.updateBranch(branch);
		
	}

	@Override
	public void deleteBranch(BigDecimal branchId) {
		// TODO Auto-generated method stub
		branchDAO.deleteBranch(branchId);
	}

}
