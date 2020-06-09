package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.dao.MerchantDAO;

@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDAO merchantDao;
//	@Autowired
//	Validation Validation;
	
	@Override
	public MerchantPermanentBean viewProfile(String email) {
		return merchantDao.viewProfile(email);
	}

	@Override
	public List<ReturnProductBean> getReturnProductList(String email) {
		return merchantDao.getReturnProductList(email);
	}

}
