package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TTreatmentDetail;


@Transactional
@Repository
public class TTreatmentDetailDAO implements ITTreatmentDetailDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TTreatmentDetail> getAllTreatmentDetails() {
		// TODO Auto-generated method stub
		String hql = "FROM TTreatmentDetail as mc ORDER BY mc.treatmentDetailId DESC";
		return (List<TTreatmentDetail>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TTreatmentDetail getTreatmentDetailById(BigDecimal TreatmentDetailId) {
		// TODO Auto-generated method stub
		return entityManager.find(TTreatmentDetail.class, TreatmentDetailId);
	}

	@Override
	public void createTreatmentDetail(TTreatmentDetail TreatmentDetail) {
		// TODO Auto-generated method stub
		entityManager.persist(TreatmentDetail);		
	}

	@Override
	public void updateTreatmentDetail(TTreatmentDetail TreatmentDetail) {
		
		TTreatmentDetail mct = getTreatmentDetailById(TreatmentDetail.getTreatmentDetailId());
		
			mct.setTreatmentDetailId(TreatmentDetail.getTreatmentDetailId());
			mct.setTreatmentId(TreatmentDetail.getTreatmentId());
			mct.setTreatmentType(TreatmentDetail.getTreatmentType());
			mct.setTreatmentDate(TreatmentDetail.getTreatmentDate());
			mct.setNote(TreatmentDetail.getNote());
			mct.setDoctorId(TreatmentDetail.getDoctorId());
			mct.setReceipt(TreatmentDetail.getReceipt());
			
			mct.setCreatedBy(TreatmentDetail.getCreatedBy());
			mct.setCreatedOn(TreatmentDetail.getCreatedOn());
			mct.setModifiedBy(TreatmentDetail.getModifiedBy());
			mct.setModifiedOn(TreatmentDetail.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteTreatmentDetail(BigDecimal TreatmentDetailId) {
		entityManager.remove(getTreatmentDetailById(TreatmentDetailId));
	}

	@Override
	public boolean TreatmentDetailExists(BigDecimal TreatmentDetailId) {
		String hql = "FROM TTreatmentDetail as mc WHERE mc.treatmentDetailId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, TreatmentDetailId).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
