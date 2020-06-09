package com.capgemini.capstore.validation;

public interface Validation {
	// Regex
		public Integer validateNumber(String id);

		public String emailIdValidate(String email);

		public Double doubleValidate(String number);
}
