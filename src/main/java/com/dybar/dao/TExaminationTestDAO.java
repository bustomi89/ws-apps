package com.dybar.dao;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.dybar.entity.TExaminationTest;

@Transactional
@Repository
public class TExaminationTestDAO implements ITExaminationTestDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TExaminationTest> getAllExaminationTests() {
		// TODO Auto-generated method stub
		String hql = "FROM TExaminationTest as mc ORDER BY mc.testId DESC";
		return (List<TExaminationTest>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public TExaminationTest getExaminationTestById(BigDecimal TestId) {
		// TODO Auto-generated method stub
		return entityManager.find(TExaminationTest.class, TestId);
	}

	@Override
	public void createExaminationTest(TExaminationTest ExaminationTest) {
		// TODO Auto-generated method stub
		entityManager.persist(ExaminationTest);		
	}

	@Override
	public void updateExaminationTest(TExaminationTest ExaminationTest) {
		// TODO Auto-generated method stub

		
		TExaminationTest mct = getExaminationTestById(ExaminationTest.getExamId());
		
			mct.setTestId(ExaminationTest.getTestId());
			mct.setExamId(ExaminationTest.getExamId());
			mct.setCategoryId(ExaminationTest.getCategoryId());
			mct.setTestDate(ExaminationTest.getTestDate());
			mct.setTestNote(ExaminationTest.getTestNote());
			mct.setTestPic(ExaminationTest.getTestPic());
			
			mct.setCreatedBy(ExaminationTest.getCreatedBy());
			mct.setCreatedOn(ExaminationTest.getCreatedOn());
			mct.setModifiedBy(ExaminationTest.getModifiedBy());
			mct.setModifiedOn(ExaminationTest.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteExaminationTest(BigDecimal TestId) {
		// TODO Auto-generated method stub
		entityManager.remove(getExaminationTestById(TestId));
	}

	@Override
	public boolean ExaminationTestExists(BigDecimal TestId) {
		// TODO Auto-generated method stub
		String hql = "FROM TExaminationTest as mc WHERE mc.testId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, TestId).getResultList().size();
		return count > 0 ? true : false;
	}

}
