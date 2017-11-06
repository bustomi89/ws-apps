package com.dybar.dao;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.MCategory;

@Transactional
@Repository
public class CategoryDAO implements ICategoryDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<MCategory> getAllCategorys() {
		// TODO Auto-generated method stub
		String hql = "FROM MCategory as mc ORDER BY mc.categoryId DESC";
		return (List<MCategory>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public MCategory getCategoryById(BigDecimal categoryId) {
		// TODO Auto-generated method stub
		return entityManager.find(MCategory.class, categoryId);
	}

	@Override
	public void createCategory(MCategory Category) {
		// TODO Auto-generated method stub
		entityManager.persist(Category);
		
	}

	@Override
	public void updateCategory(MCategory Category) {
		
		MCategory mct = getCategoryById(Category.getCategoryId());
		
			mct.setDiscount(Category.getDiscount());
			mct.setPrice(Category.getPrice());
			mct.setSize(Category.getSize());
			mct.setDescription(Category.getDescription());
			mct.setCategoryCode(Category.getCategoryCode());
			mct.setCategoryName(Category.getCategoryName());
			mct.setCategoryType(Category.getCategoryType());
			mct.setCategoryId(Category.getCategoryId());
			mct.setCreatedBy(Category.getCreatedBy());
			mct.setCreatedOn(Category.getCreatedOn());
			mct.setModifiedBy(Category.getModifiedBy());
			mct.setModifiedOn(Category.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteCategory(BigDecimal CategoryId) {
		entityManager.remove(getCategoryById(CategoryId));
	}

	@Override
	public boolean CategoryExists(BigDecimal CategoryId, String CategoryCode) {
		String hql = "FROM MCategory as mc WHERE mc.categoryId = ? and mc.categoryCode = ?";
		int count = entityManager.createQuery(hql).setParameter(1, CategoryId)
		              .setParameter(2, CategoryCode).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
