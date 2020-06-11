package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.dao.ProductDAO;
import com.capgemini.capstore.exception.CapstoreCustomException;
import com.capgemini.capstore.validation.CapstoreValidation;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	CapstoreValidation capstoreValidation;
	
//	@Autowired
//	 public ProductServiceImpl(ProductDAO productDAO) {
//		this.productDAO = productDAO;
//	}

	@Override
	public List<ProductBean> showAllProducts() {
		productDAO.deleteDiscountAfterExpiryDate();
		return productDAO.showAllProducts();
	}//End of showAllProducts()

	
	@Override
	public boolean addProduct(ProductBean productBean) {
		if (capstoreValidation.productName(productBean.getProductName())) {
			if (capstoreValidation.productBrandName(productBean.getProductBrandName())) {
				if (capstoreValidation.productCategory(productBean.getProductCategory())) {
					if (capstoreValidation.productQuantity(productBean.getProductQuantity())) {
						if (capstoreValidation.productPrice(productBean.getProductPrice())) {
							if (capstoreValidation.productDiscountExpiryDate(productBean.getProductDiscountExpiryDate())) {
								return productDAO.addProduct(productBean);
							} else {
								throw new CapstoreCustomException("The Date Must be greater than equal to current date");
							}
						
						} else {
							throw new CapstoreCustomException("Price must contain digits only");
						}
						
					}else {
						throw new CapstoreCustomException("Quantity must contain digits only");
					}
				} else {
					throw new CapstoreCustomException("Category must contain characters only");
				}
			} else {
				throw new CapstoreCustomException("Brand name can contain characters or numbers");
			}
		} else {
			throw new CapstoreCustomException("Product name can contain characters or numbers");
		}
		
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDAO.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		if (capstoreValidation.productName(productBean.getProductName())) {
			if (capstoreValidation.productBrandName(productBean.getProductBrandName())) {
				if (capstoreValidation.productCategory(productBean.getProductCategory())) {
					if (capstoreValidation.productQuantity(productBean.getProductQuantity())) {
						if (capstoreValidation.productPrice(productBean.getProductPrice())) {
							if (capstoreValidation.productDiscountExpiryDate(productBean.getProductDiscountExpiryDate())) {
								return productDAO.updateProduct(productBean);
							} else {
								throw new CapstoreCustomException("The Date Must be greater than equal to current date");
							}
						
						} else {
							throw new CapstoreCustomException("Price must contain digits only");
						}
						
					}else {
						throw new CapstoreCustomException("Quantity must contain digits only");
					}
				} else {
					throw new CapstoreCustomException("Category must contain characters only");
				}
			} else {
				throw new CapstoreCustomException("Brand name can contain characters or numbers");
			}
		} else {
			throw new CapstoreCustomException("Product name can contain characters or numbers");
		}
	}
	
	@Override
	public List<ProductBean> showMerchantProducts(String email) {
		if (capstoreValidation.emailValidation(email)) {
			return productDAO.showMerchantProducts(email);
		} else {
			throw new CapstoreCustomException("Please Enter Email in valid Format");
		}
	}

	
}
