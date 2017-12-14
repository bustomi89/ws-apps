package com.dybar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dybar.dao.IVExaminationDAO;
import com.dybar.entity.VExamination;

@Service
public class VExaminationService  implements IVExaminationService {

	@Autowired
	private IVExaminationDAO ExaminationDAO;

	@Override
	public VExamination getExaminationById(BigDecimal ExaminationId) {
		VExamination obj = ExaminationDAO.getExaminationById(ExaminationId);
		return obj;
	}

	@Override
	public List<VExamination> getAllExaminations() {
		// TODO Auto-generated method stub
		return ExaminationDAO.getAllExaminations();
	}

}
