package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.IPetDAO;
import com.dybar.entity.TPet;
@Service
public class PetService implements IPetService{

	@Autowired
	private IPetDAO petDAO;

	@Override
	public TPet getPetById(BigDecimal PetId) {
		TPet obj = petDAO.getPetById(PetId);
		return obj;
	}
	
	@Override
	public List<TPet> getAllPet() {
		// TODO Auto-generated method stub
		return petDAO.getAllPet();
	}


	@Override
	public boolean createPet(TPet pet) {
	       if (petDAO.PetExists(pet.getPetId())) {
	    	   return false;
	       } else {
	    	   petDAO.createPet(pet);
	    	   return true;
	       }
	}

	@Override
	public void updatePet(TPet pet) {
		petDAO.updatePet(pet);
		
	}

	@Override
	public void deletePet(BigDecimal petId) {
		petDAO.deletePet(petId);
	}

}
