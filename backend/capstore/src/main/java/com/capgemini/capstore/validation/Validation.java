package com.capgemini.capstore.validation;

public interface Validation {
	public boolean emailValidation(String email);

	public boolean passwordValidation(String password);
	
	public boolean mobileNoValidation(String phoneNumber);
}
