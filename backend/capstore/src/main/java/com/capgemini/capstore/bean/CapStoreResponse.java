package com.capgemini.capstore.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CapStoreResponse {
	private int statusCode;
	private String message;
	private String description;
	private ProductBean productBean;
	private List<ProductBean> productList;
	private MerchantPermanentBean merchantPermanentBean;
	private List<ReturnProductBean> returnProductList;
	
	//Getters and Setters methods
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public List<ProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}
	
	public MerchantPermanentBean getMerchantPermanentBean() {
		return merchantPermanentBean;
	}
	public void setMerchantPermanentBean(MerchantPermanentBean merchantPermanentBean) {
		this.merchantPermanentBean = merchantPermanentBean;
	}
	public List<ReturnProductBean> getReturnProductList() {
		return returnProductList;
	}
	public void setReturnProductList(List<ReturnProductBean> returnProductList) {
		this.returnProductList = returnProductList;
	}
	
	
	
}//End of Class
