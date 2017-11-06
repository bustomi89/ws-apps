package com.dybar.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.MBranch;

@Transactional
@Repository
public class BranchDAO implements IBranchDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<MBranch> getAllBranchs() {
		// TODO Auto-generated method stub
		String hql = "FROM MBranch as mb ORDER BY mb.branchId DESC";
		return (List<MBranch>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public MBranch getBranchById(BigDecimal BranchId) {
		// TODO Auto-generated method stub
		return entityManager.find(MBranch.class, BranchId);
	}

	@Override
	public void createBranch(MBranch Branch) {
		// TODO Auto-generated method stub
		entityManager.persist(Branch);
	}

	@Override
	public void updateBranch(MBranch Branch) {
		MBranch mb = getBranchById(Branch.getBranchId());
		
			mb.setPostalCode(Branch.getPostalCode());
			mb.setBranchLevel(Branch.getBranchLevel());
			mb.setActiveStatus(Branch.getActiveStatus());
			mb.setDescription(Branch.getDescription());
			mb.setBranchName(Branch.getBranchName());
			mb.setBranchCode(Branch.getBranchCode());
			mb.setBranchId(Branch.getBranchId());
			mb.setCreatedBy(Branch.getCreatedBy());
			mb.setCreatedOn(Branch.getCreatedOn());
			mb.setModifiedBy(Branch.getModifiedBy());
			mb.setModifiedOn(Branch.getModifiedOn());
			
	entityManager.flush();
		
	}

	@Override
	public void deleteBranch(BigDecimal BranchId) {
		entityManager.remove(getBranchById(BranchId));
	}

	@Override
	public boolean BranchExists(BigDecimal BranchId, String BranchCode) {
		// TODO Auto-generated method stub
		String hql = "FROM MBranch as mc WHERE mc.branchId = ? and mc.branchCode = ?";
		int count = entityManager.createQuery(hql).setParameter(1, BranchId)
		              .setParameter(2, BranchCode).getResultList().size();
		return count > 0 ? true : false;
	}

}
