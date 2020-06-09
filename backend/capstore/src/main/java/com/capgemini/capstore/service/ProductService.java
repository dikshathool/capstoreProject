package com.capgemini.capstore.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.ProductBean;

public interface ProductService {
	public List<ProductBean> showAllProducts();
	
	// add product
	public boolean addProduct(ProductBean productBean);

	// delete product
	public boolean deleteProduct(int productId);

	// update product
	public boolean updateProduct(ProductBean productBean);
	
	public List<ProductBean> showMerchantProducts(String email);
	
	public List<CouponBean> showCoupon();
	
	public boolean addCoupon(CouponBean couponBean);
}//End of interface
