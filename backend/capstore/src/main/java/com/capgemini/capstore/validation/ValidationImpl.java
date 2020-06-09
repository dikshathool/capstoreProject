package com.capgemini.capstore.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {

	// Regex
	@Override
	public Integer validateNumber(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if (mat.matches()) {
			return Integer.parseInt(id);
		} else {
			return null;
		}
	}// End of numberValidate()

	@Override
	public String emailIdValidate(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		} else {
			return null;
		}
	}// End of emailIdValidate()

	@Override
	public Double doubleValidate(String number) {
		Pattern pat = Pattern.compile("\\d+.\\d\\d");
		Matcher mat = pat.matcher(number);
		if (mat.matches()) {
			return Double.parseDouble(number);
		}
		return null;
	}// End of doubleValidate()

	
}
