package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CapStoreResponse;
import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.service.MerchantService;

@RestController
//To connect rest with angular
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MerchantController {
	
	private MerchantService merchantService;
	
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
	public CapStoreResponse getReturnProductList(@RequestParam String email) {
		List<ReturnProductBean> productList = merchantService.getReturnProductList(email);
		CapStoreResponse capstoreResponseBean = new CapStoreResponse();
		capstoreResponseBean.setStatusCode(200);
		capstoreResponseBean.setMessage("success");
		capstoreResponseBean.setDescription("Return Product List Found...");
		capstoreResponseBean.setReturnProductList(productList);
		return capstoreResponseBean;
	}
}
