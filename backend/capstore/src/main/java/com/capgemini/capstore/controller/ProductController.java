package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CapStoreResponse;
import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.service.MerchantService;
import com.capgemini.capstore.service.ProductService;

@RestController
//To connect rest with angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	private ProductService productService;
	private MerchantService merchantService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	CapStoreResponse capStoreResponse = new CapStoreResponse();

	@GetMapping(path = "/getProductList")
	public CapStoreResponse showAllProducts() {
		List<ProductBean> productList = productService.showAllProducts();
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (productList != null && !productList.isEmpty()) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product Records Found...");
			capStoreResponse.setProductList(productList);
		} else {
			capStoreResponse.setStatusCode(400);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Enable to Fetch Product Records!");
		}
		return capStoreResponse;
	}// End of showAllProducts()
	
	@GetMapping(path = "/getMerchantProductList")
	public CapStoreResponse showMerchantProducts(@RequestParam String email) {
		List<ProductBean> productList = productService.showMerchantProducts(email);
		CapStoreResponse capStoreResponse = new CapStoreResponse();
		if (productList != null && !productList.isEmpty()) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product Records Found...");
			capStoreResponse.setProductList(productList);
		} else {
			capStoreResponse.setStatusCode(400);
			capStoreResponse.setMessage("Failed");
			capStoreResponse.setDescription("Enable to Fetch Product Records!");
		}
		return capStoreResponse;
	}// End of showAllProducts()

	// Add Product
	@PostMapping("/addProduct")
	public CapStoreResponse addProduct(@RequestBody ProductBean productBean) {
		boolean isProductAdded = productService.addProduct(productBean);
		if (isProductAdded) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product added successfully");
		}
		return capStoreResponse;
	}// End of addProduct()

	// Delete product
	@DeleteMapping("/deleteProduct")
	public CapStoreResponse deleteProduct(@RequestParam int productId) {
		boolean deleteProduct = productService.deleteProduct(productId);
		if (deleteProduct) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product deleted successfully");
		}
		return capStoreResponse;
	}// End of deleteProduct()

	// Update product
	@PostMapping(path = "/updateProduct")
	public CapStoreResponse updateProduct(@RequestBody ProductBean productBean) {
		boolean productUpdated = productService.updateProduct(productBean);
		if (productUpdated) {
			capStoreResponse.setStatusCode(201);
			capStoreResponse.setMessage("Success");
			capStoreResponse.setDescription("Product updated successfully");
		}
		return capStoreResponse;
	}// End of updateProduct()

		
		@GetMapping("/viewProfile")
		public CapStoreResponse viewProfile(@RequestParam String email) {
			CapStoreResponse capstoreResponseBean = new CapStoreResponse();
			MerchantPermanentBean merchantPermanentBean = merchantService.viewProfile(email);
			capstoreResponseBean.setStatusCode(200);
			capstoreResponseBean.setMessage("success");
			capstoreResponseBean.setDescription(" Profile Found");
			capstoreResponseBean.setMerchantPermanentBean(merchantPermanentBean);
			return capstoreResponseBean;

		}
		
		@GetMapping("/getReturnProductList")
		public CapStoreResponse getReturnProductList(@RequestParam int productId) {
			List<ReturnProductBean> productList = merchantService.getReturnProductList(productId);
			CapStoreResponse capstoreResponseBean = new CapStoreResponse();
			capstoreResponseBean.setStatusCode(200);
			capstoreResponseBean.setMessage("success");
			capstoreResponseBean.setDescription("Return Product List Found...");
			capstoreResponseBean.getProductList();
			return capstoreResponseBean;
		}

}// End of Class
