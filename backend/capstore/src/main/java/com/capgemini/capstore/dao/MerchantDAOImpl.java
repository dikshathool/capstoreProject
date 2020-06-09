package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.exception.MerchantException;

@Repository
public class MerchantDAOImpl implements MerchantDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<ReturnProductBean> getReturnProductList(int merchantId) {
		
		List<ReturnProductBean> productList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from ReturnProductBean where merchantId =:merchantId ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("merchantId", merchantId);
			productList = (List<ReturnProductBean>) query.getResultList();
			if (productList == null || productList.isEmpty()) {
				throw new MerchantException("Return Product List folder is empty");
			}
		} catch (Exception e) {
			throw new MerchantException("Return Product List folder is empty");
		}
		return productList;
	}
	
	@Override
	public MerchantPermanentBean viewProfile(String email) {
		MerchantPermanentBean merchantPermanentBean = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from MerchantPermanentBean where email=:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			merchantPermanentBean = (MerchantPermanentBean) query.getSingleResult();
		} catch (Exception e) {
			throw new MerchantException("Email not Present");
		}
		return merchantPermanentBean;
	}
}
