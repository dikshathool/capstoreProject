package com.capgemini.capstore.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.ProductBean;

public interface ProductDAO {
	//show all products
	public List<ProductBean> showAllProducts();
	
	//delete discount after expiry date
	public void deleteDiscountAfterExpiryDate();
	
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