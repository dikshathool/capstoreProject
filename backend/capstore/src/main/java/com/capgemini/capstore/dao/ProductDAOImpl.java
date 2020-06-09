package com.capgemini.capstore.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.exception.CapstoreCustomException;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	// Add product
	@Override
	public boolean addProduct(ProductBean productBean) {
		boolean addProduct = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(productBean);
			entityTransaction.commit();
			entityManager.close();
			addProduct = true;
		} catch (Exception e) {
			throw new CapstoreCustomException("Unable to add product");
		}
		return addProduct;
	}

	// Delete product
	@Override
	public boolean deleteProduct(int productId) {
		boolean product = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			ProductBean productBean = entityManager.find(ProductBean.class, productId);
			entityManager.remove(productBean);
			entityTransaction.commit();
			product = true;
		} catch (Exception e) {
			throw new CapstoreCustomException("Unable to delete product");
		}
		return product;
	}

	// Update product
	@Override
	public boolean updateProduct(ProductBean productBean) {
		entityManager = entityManagerFactory.createEntityManager();
		ProductBean existingProductDetails = entityManager.find(ProductBean.class, productBean.getProductId());
		boolean productUpdated = false;

		if (existingProductDetails != null) {

			String productName = productBean.getProductName();
			if (productName != null) {
				existingProductDetails.setProductName(productName);
			}

			String productPrice = productBean.getProductPrice();
			if (productPrice != null) {
				existingProductDetails.setProductPrice(productPrice);
			}

			String productQuantity = productBean.getProductQuantity();
			if (productQuantity != null) {
				existingProductDetails.setProductQuantity(productQuantity);
			}

			String productCategory = productBean.getProductCategory();
			if (productCategory != null) {
				existingProductDetails.setProductCategory(productCategory);
			}

			String productImage = productBean.getProductImage();
			if (productImage != null) {
				existingProductDetails.setProductImage(productImage);
			}

			double productDiscount = productBean.getProductDiscount();
			if (productDiscount >= 0) {
				existingProductDetails.setProductDiscount(productDiscount);
			}

			LocalDate productDiscountExpiryDate = productBean.getProductDiscountExpiryDate();
			if (productDiscountExpiryDate != null) {
				existingProductDetails.setProductDiscountExpiryDate(productDiscountExpiryDate);
			}

			String productBrandName = productBean.getProductBrandName();
			if (productBrandName != null) {
				existingProductDetails.setProductBrandName(productBrandName);
			}

			String email = productBean.getEmail();
			if (email != null) {
				existingProductDetails.setEmail(email);
			}

			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingProductDetails);
				entityTransaction.commit();
				productUpdated = true;
			} catch (Exception e) {
				throw new CapstoreCustomException("Unable to update product");
			}
			entityManager.close();
		}
		return productUpdated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> showAllProducts() {
			List<ProductBean> productList = null;
		entityManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<ProductBean> query = entityManager.createQuery("from ProductBean", ProductBean.class);
			productList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreCustomException("There is no Products Present");
		}
		return productList;
	}// End of showAllProducts()

	@SuppressWarnings("unchecked")
	@Override
	public void deleteDiscountAfterExpiryDate() {
		LocalDate currentDate = LocalDate.now();
		try {
			List<ProductBean> products = showAllProducts();
			if (products != null) {
				for (ProductBean product : products) {
					if (currentDate.compareTo(product.getProductDiscountExpiryDate()) >= 1) {
						product.setProductDiscount(0);
						updateProduct(product);
					}
				}
			}
		} catch (Exception e) {
			throw new CapstoreCustomException("No Matched Records are Present");
		}
	}// End of deleteDiscountAfterExpiryDate()

	@Override
	public List<CouponBean> showCoupon() {
		List<CouponBean> couponList = null;
		entityManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<CouponBean> query = entityManager.createQuery("from CouponBean", CouponBean.class);
			couponList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreCustomException("There is no Products Present");
		}
		return couponList;
	}

	@Override
	public boolean addCoupon(CouponBean couponBean) {
		boolean isAdded = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(couponBean);
			entityTransaction.commit();
			entityManager.close();
			isAdded = true;
		} catch (Exception e) {
			throw new CapstoreCustomException("Unable to add product");
		}
		return isAdded;
	}

	@Override
	public List<ProductBean> showMerchantProducts(String email) {
		List<ProductBean> productList = null;
		entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "FROM ProductBean WHERE email =: email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			productList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreCustomException("There is no Products Present");
		}
		return productList;
	}

}// End of Class
