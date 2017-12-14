package com.dybar.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.SyParameterlist;;

@Transactional
@Repository
public class SyParamDAO implements ISyParamDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<SyParameterlist> getAllSyParams() {
		// TODO Auto-generated method stub
		String hql = "FROM MSyParam as mb ORDER BY mb.SyParamId DESC";
		return (List<SyParameterlist>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public SyParameterlist getSyParamById(BigDecimal SyParamId) {
		// TODO Auto-generated method stub
		return entityManager.find(SyParameterlist.class, SyParamId);
	}

//	@Override
//	public void createSyParam(SyParameterlist SyParam) {
//		// TODO Auto-generated method stub
//		entityManager.persist(SyParam);
//	}
//
//	@Override
//	public void updateSyParam(SyParameterlist SyParam) {
//		SyParameterlist mb = getSyParamById(SyParam.getSyParamId());
//		
//			mb.setPostalCode(SyParam.getPostalCode());
//			mb.setSyParamLevel(SyParam.getSyParamLevel());
//			mb.setActiveStatus(SyParam.getActiveStatus());
//			mb.setDescription(SyParam.getDescription());
//			mb.setSyParamName(SyParam.getSyParamName());
//			mb.setSyParamCode(SyParam.getSyParamCode());
//			mb.setSyParamId(SyParam.getSyParamId());
//			mb.setCreatedBy(SyParam.getCreatedBy());
//			mb.setCreatedOn(SyParam.getCreatedOn());
//			mb.setModifiedBy(SyParam.getModifiedBy());
//			mb.setModifiedOn(SyParam.getModifiedOn());
//			
//	entityManager.flush();
//		
//	}
//
//	@Override
//	public void deleteSyParam(BigDecimal SyParamId) {
//		entityManager.remove(getSyParamById(SyParamId));
//	}

	@Override
	public boolean SyParamExists(BigDecimal SyParamId, String SyParamCode) {
		// TODO Auto-generated method stub
		String hql = "FROM MSyParam as mc WHERE mc.SyParamId = ? and mc.SyParamCode = ?";
		int count = entityManager.createQuery(hql).setParameter(1, SyParamId)
		              .setParameter(2, SyParamCode).getResultList().size();
		return count > 0 ? true : false;
	}

}
