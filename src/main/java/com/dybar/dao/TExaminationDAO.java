package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TExamination;


@Transactional
@Repository
public class TExaminationDAO implements ITExaminationDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TExamination> getAllExaminations() {
		// TODO Auto-generated method stub
		String hql = "FROM TExamination as mc ORDER BY mc.examId DESC";
		return (List<TExamination>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TExamination getExaminationById(BigDecimal ExaminationId) {
		// TODO Auto-generated method stub
		return entityManager.find(TExamination.class, ExaminationId);
	}

	@Override
	public void createExamination(TExamination Examination) {
		// TODO Auto-generated method stub
		entityManager.persist(Examination);		
	}

	@Override
	public void updateExamination(TExamination Examination) {
		
		TExamination mct = getExaminationById(Examination.getExamId());
		
			mct.setExamId(Examination.getExamId());
			mct.setPetId(Examination.getPetId());
			mct.setHistoryNote(Examination.getHistoryNote());
			mct.setTemperature(Examination.getTemperature());
			mct.setWeight(Examination.getWeight());
			mct.setPulseRate(Examination.getPulseRate());
			mct.setHeartRate(Examination.getHeartRate());
			mct.setRespRate(Examination.getRespRate());
			mct.setIndexBody(Examination.getIndexBody());
			mct.setNote(Examination.getNote());
			mct.setCustomerType(Examination.getCustomerType());
			
			mct.setCreatedBy(Examination.getCreatedBy());
			mct.setCreatedOn(Examination.getCreatedOn());
			mct.setModifiedBy(Examination.getModifiedBy());
			mct.setModifiedOn(Examination.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteExamination(BigDecimal ExaminationId) {
		entityManager.remove(getExaminationById(ExaminationId));
	}

	@Override
	public boolean ExaminationExists(BigDecimal ExaminationId) {
		String hql = "FROM TExamination as mc WHERE mc.examId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, ExaminationId).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
