package com.dybar.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dybar.entity.TCustomer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TCustomer> getAllCustomer() {
		// TODO Auto-generated method stub
		String hql = "FROM t_customer as mc ORDER BY mc.customer_id DESC";
		return (List<TCustomer>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public TCustomer getCustomerById(BigDecimal customer_id) {
		// TODO Auto-generated method stub
		return entityManager.find(TCustomer.class, customer_id);
	}

	@Override
	public void createCustomer(TCustomer Customer) {
		// TODO Auto-generated method stub
		entityManager.persist(Customer);
		
	}

	@Override
	public void updateCustomer(TCustomer Customer) {
		TCustomer mct = getCustomerById(Customer.getCustomerId());
			mct.setCustomerName(Customer.getCustomerName());
			mct.setCustomerId(Customer.getCustomerId());
			mct.setCustomerAge(Customer.getCustomerAge());
			mct.setClientAddress(Customer.getClientAddress());
			mct.setPostalCode(Customer.getPostalCode());
			mct.setBirthdate(Customer.getBirthdate());
			mct.setPhoneNumber(Customer.getPhoneNumber());
			mct.setEmail(Customer.getEmail());
			mct.setIdentityType(Customer.getIdentityType());
			mct.setIdentityNumber(Customer.getIdentityNumber());
			mct.setReference(Customer.getReference());
			mct.setDeposite(Customer.getDeposite());
			mct.setCreatedBy(Customer.getCreatedBy());
			mct.setCreatedOn(Customer.getCreatedOn());
			mct.setModifiedBy(Customer.getModifiedBy());
			mct.setModifiedOn(Customer.getModifiedOn());
			
		entityManager.flush();
	}

	@Override
	public void deleteCustomer(BigDecimal CustomerId) {
		entityManager.remove(getCustomerById(CustomerId));
	}

	@Override
	public boolean CustomerExists(BigDecimal CustomerId) {
		String hql = "FROM t_customer as mc WHERE mc.customer_id = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, CustomerId)
		              .getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
