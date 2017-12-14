package com.dybar.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.VExamination;

@Transactional
@Repository
public class VExaminationDAO  implements IVExaminationDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VExamination> getAllExaminations() {
		// TODO Auto-generated method stub
		String hql = "FROM VExamination as mc ORDER BY mc.examId DESC";
		return (List<VExamination>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public VExamination getExaminationById(BigDecimal ExaminationId) {
		// TODO Auto-generated method stub
		return entityManager.find(VExamination.class, ExaminationId);
	}

	@Override
	public boolean ExaminationExists(BigDecimal ExaminationId) {
		String hql = "FROM VExamination as mc WHERE mc.examId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, ExaminationId).getResultList().size();
		return count > 0 ? true : false;
	}

}
