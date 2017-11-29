package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TTreatment;

@Transactional
@Repository
public class TreatmentDAO implements ITreatmentDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TTreatment> getAllTreatment() {
		// TODO Auto-generated method stub
		String hql = "FROM TTreatment as mc ORDER BY mc.treatmentId DESC";
		return (List<TTreatment>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TTreatment getTreatmentById(BigDecimal treatment_id) {
		// TODO Auto-generated method stub
		return entityManager.find(TTreatment.class, treatment_id);
	}

	@Override
	public void createTreatment(TTreatment Treatment) {
		// TODO Auto-generated method stub
		entityManager.persist(Treatment);
		
	}

	@Override
	public void updateTreatment(TTreatment Treatment) {
		TTreatment mct = getTreatmentById(Treatment.getTreatmentId());
			mct.setPetId(Treatment.getPetId());
			mct.setTreatmentPlan(Treatment.getTreatmentPlan());
			mct.setRecommendation(Treatment.getRecommendation());
			mct.setReminder(Treatment.getReminder());
			mct.setCreatedBy(Treatment.getCreatedBy());
			mct.setCreatedOn(Treatment.getCreatedOn());
			mct.setModifiedBy(Treatment.getModifiedBy());
			mct.setModifiedOn(Treatment.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteTreatment(BigDecimal TreatmentId) {
		entityManager.remove(getTreatmentById(TreatmentId));
	}

	@Override
	public boolean TreatmentExists(BigDecimal TreatmentId) {
		String hql = "FROM TTreatment as mc WHERE mc.treatmentId = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, TreatmentId)
		              .getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
