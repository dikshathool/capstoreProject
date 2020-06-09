package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;

public interface MerchantDAO {
	public List<ReturnProductBean> getReturnProductList(int merchantId);
	
	public MerchantPermanentBean viewProfile(String email);
}//End of interface
