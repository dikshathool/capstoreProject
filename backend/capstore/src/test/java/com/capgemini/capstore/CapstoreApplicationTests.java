package com.capgemini.capstore;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.service.ProductService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapstoreApplicationTests {

	public ProductBean productBean;
	@Autowired
	private ProductService productService;
	
	@BeforeEach
	public void createObject() {
		productBean = new ProductBean();
	}
	
	@Test
	public void getProducts() {
		TestCase.assertNotNull(productService.showAllProducts());
	}
	

//	@Test
//	public void getMerchantProducts(String email) {
//		TestCase.assertNotNull(productService.showMerchantProducts("mohinikesare@gmail.com"));
//	}

	@Test
	public void deleteProduct() {
		productBean = new ProductBean();
		TestCase.assertEquals(true, productService.deleteProduct(2350));
	}
	
	@Test
	public void testUpdateProduct() {
		productBean = new ProductBean();
		productBean.setProductId(2345);
		productBean.setProductBrandName("Samsung");
		productBean.setProductCategory("Electronics");
		productBean.setProductDiscount(10);
		productBean.setProductImage("https://images.samsung.com/is/image/samsung/in-top-mount-freezer-rt34m5518s8-rt34m5518s8-hl-frontsilver-91079190?$PD_GALLERY_L_JPG$");
		productBean.setProductName("Refrigerator");
		productBean.setProductPrice("45000.00");
		productBean.setProductQuantity("20");
		boolean expected = true;
		boolean actual = productService.updateProduct(productBean);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAddProduct() {
		productBean = new ProductBean();
		productBean.setProductBrandName("Philips");
		productBean.setProductCategory("Electronics");
		productBean.setProductDiscount(10);
		productBean.setProductImage("https://images.samsung.com/is/image/samsung/in-top-mount-freezer-rt34m5518s8-rt34m5518s8-hl-frontsilver-91079190?$PD_GALLERY_L_JPG$");
		productBean.setProductName("LED TV");
		productBean.setProductPrice("30000");
		LocalDate expiryDate = LocalDate.parse("2019-12-30");
		productBean.setProductDiscountExpiryDate(expiryDate);
		productBean.setProductQuantity("25");
		productBean.setEmail("philips123@gmail.com");
		boolean expected = true;
		boolean actual = productService.addProduct(productBean);
		Assert.assertEquals(expected, actual);
	}
	

}
