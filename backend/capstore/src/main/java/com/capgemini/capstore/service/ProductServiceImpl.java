package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	private ProductDAO productDAO;
	
	@Autowired
	 public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<ProductBean> showAllProducts() {
		productDAO.deleteDiscountAfterExpiryDate();
		return productDAO.showAllProducts();
	}//End of showAllProducts()

	
	@Override
	public boolean addProduct(ProductBean productBean) {
		return productDAO.addProduct(productBean);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDAO.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		return productDAO.updateProduct(productBean);
	}
	
	@Override
	public List<ProductBean> showMerchantProducts(String email) {
		return productDAO.showMerchantProducts(email);
	}


	@Override
	public List<CouponBean> showCoupon() {
		return productDAO.showCoupon();
	}

	@Override
	public boolean addCoupon(CouponBean couponBean) {
		return productDAO.addCoupon(couponBean);
	}

	
}
