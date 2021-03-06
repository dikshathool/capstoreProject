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
	public List<ReturnProductBean> getReturnProductList(String email) {
		
		List<ReturnProductBean> productList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from ReturnProductBean where email =:email ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
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
		System.err.println(email);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from MerchantPermanentBean where email=:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			merchantPermanentBean = (MerchantPermanentBean) query.getSingleResult();
			System.err.println(merchantPermanentBean);
		} catch (Exception e) {
			throw new MerchantException("Email not Present");
		}
		return merchantPermanentBean;
	}
}
