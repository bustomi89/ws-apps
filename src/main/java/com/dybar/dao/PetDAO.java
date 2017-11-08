package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TPet;

@Transactional
@Repository
public class PetDAO implements IPetDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TPet> getAllPet() {
		// TODO Auto-generated method stub
		String hql = "FROM t_pet as mc ORDER BY mc.pet_id DESC";
		return (List<TPet>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TPet getPetById(BigDecimal pet_id) {
		// TODO Auto-generated method stub
		return entityManager.find(TPet.class, pet_id);
	}

	@Override
	public void createPet(TPet Pet) {
		// TODO Auto-generated method stub
		entityManager.persist(Pet);
		
	}

	@Override
	public void updatePet(TPet Pet) {
		TPet mct = getPetById(Pet.getPetId());
			mct.setPetName(Pet.getPetName());
			mct.setCustomerId(Pet.getCustomerId());
			mct.setDoctorId(Pet.getDoctorId());
			mct.setSpeciesId(Pet.getSpeciesId());
			mct.setPetSex(Pet.getPetSex());
			mct.setPetBirthdate(Pet.getPetBirthdate());
			mct.setPetAge(Pet.getPetAge());
			mct.setBreed(Pet.getBreed());
			mct.setColor(Pet.getColor());
			mct.setCreatedBy(Pet.getCreatedBy());
			mct.setCreatedOn(Pet.getCreatedOn());
			mct.setModifiedBy(Pet.getModifiedBy());
			mct.setModifiedOn(Pet.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deletePet(BigDecimal PetId) {
		entityManager.remove(getPetById(PetId));
	}

	@Override
	public boolean PetExists(BigDecimal PetId) {
		String hql = "FROM t_pet as mc WHERE mc.pet_id = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, PetId)
		              .getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
