package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;

public interface MerchantService {
	public List<ReturnProductBean> getReturnProductList(int merchantId) ;
	
	public MerchantPermanentBean viewProfile(String email);
}
