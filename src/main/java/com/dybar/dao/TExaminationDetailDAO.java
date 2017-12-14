package com.dybar.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TExaminationDetail;


@Transactional
@Repository
public class TExaminationDetailDAO implements ITExaminationDetailDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TExaminationDetail> getAllExaminationDetails() {
		// TODO Auto-generated method stub
		String hql = "FROM TExaminationDetail as mc ORDER BY mc.examDetailId DESC";
		return (List<TExaminationDetail>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TExaminationDetail getExaminationDetailById(BigDecimal ExaminationDetailId) {
		// TODO Auto-generated method stub
		return entityManager.find(TExaminationDetail.class, ExaminationDetailId);
	}

	@Override
	public void createExaminationDetail(TExaminationDetail ExaminationDetail) {
		// TODO Auto-generated method stub
		entityManager.persist(ExaminationDetail);		
	}

	@Override
	public void updateExaminationDetail(TExaminationDetail ExaminationDetail) {
		
		TExaminationDetail mct = getExaminationDetailById(ExaminationDetail.getExamDetailId());
		
			mct.setExamDetailId(ExaminationDetail.getExamDetailId());
			mct.setExamId(ExaminationDetail.getExamId());
			mct.setParamExamId(ExaminationDetail.getParamExamId());
			mct.setFlagExam(ExaminationDetail.getFlagExam());
			
			mct.setCreatedBy(ExaminationDetail.getCreatedBy());
			mct.setCreatedOn(ExaminationDetail.getCreatedOn());
			mct.setModifiedBy(ExaminationDetail.getModifiedBy());
			mct.setModifiedOn(ExaminationDetail.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteExaminationDetail(BigDecimal ExaminationDetailId) {
		entityManager.remove(getExaminationDetailById(ExaminationDetailId));
	}

	@Override
	public boolean ExaminationDetailExists(BigDecimal ExaminationDetailId) {
		String hql = "FROM TExaminationDetail as mc WHERE mc.examDetailId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, ExaminationDetailId).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
