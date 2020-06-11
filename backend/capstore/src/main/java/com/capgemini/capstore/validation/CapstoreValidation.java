package com.capgemini.capstore.validation;

import java.time.LocalDate;

public interface CapstoreValidation {
	public boolean productName(String productName);

	public boolean productPrice(String productPrice);
	
	public boolean productQuantity(String productQuantity);
	
	public boolean productCategory(String productCategory);
	
	public boolean productDiscountExpiryDate(LocalDate productDiscountExpiryDate);
	
	public boolean productBrandName(String productBrandName);
	
	public boolean emailValidation(String email);

}
