package com.dybar.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.MCategory;
import com.dybar.entity.MDoctor;

@Transactional
@Repository
public class DoctorDAO implements IDoctorDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<MDoctor> getAllDoctor() {
		// TODO Auto-generated method stub
		String hql = "FROM MDoctor as mc ORDER BY mc.doctorId DESC";
		return (List<MDoctor>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public MDoctor getDoctorById(BigDecimal doctor_id) {
		// TODO Auto-generated method stub
		return entityManager.find(MDoctor.class, doctor_id);
	}

	@Override
	public void createDoctor(MDoctor Doctor) {
		// TODO Auto-generated method stub
		entityManager.persist(Doctor);
		
	}

	@Override
	public void updateDoctor(MDoctor Doctor) {
		
		MDoctor mct = getDoctorById(Doctor.getDoctorId());
			mct.setDoctorName(Doctor.getDoctorName());
			mct.setDoctorAddress(Doctor.getDoctorAddress());
			mct.setDoctorEmail(Doctor.getDoctorEmail());
			mct.setDoctorHandphone(Doctor.getDoctorHandphone());
			mct.setDoctorSip(Doctor.getDoctorSip());
			mct.setDoctorCode(Doctor.getDoctorCode());
			mct.setCreatedBy(Doctor.getCreatedBy());
			mct.setCreatedOn(Doctor.getCreatedOn());
			mct.setModifiedBy(Doctor.getModifiedBy());
			mct.setModifiedOn(Doctor.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteDoctor(BigDecimal DoctorId) {
		entityManager.remove(getDoctorById(DoctorId));
	}

	@Override
	public boolean DoctorExists(BigDecimal DoctorId, String DoctorCode) {
		String hql = "FROM MDoctor as mc WHERE mc.doctorId = ? and mc.doctorCode = ?";
		int count = entityManager.createQuery(hql).setParameter(1, DoctorId)
		              .setParameter(2, DoctorCode).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
