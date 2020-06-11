package com.capgemini.capstore.validation;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class CapstoreValidationImpl implements CapstoreValidation {
	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean productName(String productName) {
		pattern = Pattern.compile("[a-zA-Z0-9]+");
		matcher = pattern.matcher(productName);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean productPrice(String productPrice) {
		pattern = Pattern.compile("^\\d+(\\.\\d+)*$");
		matcher = pattern.matcher(productPrice);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean productQuantity(String productQuantity) {
		pattern = Pattern.compile("[+-]?[0-9][0-9]*");
		matcher = pattern.matcher(productQuantity);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean productCategory(String productCategory) {
		pattern = Pattern.compile("^[a-zA-Z\\s]*$");
		matcher = pattern.matcher(productCategory);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean productDiscountExpiryDate(LocalDate productDiscountExpiryDate) {
		LocalDate currentDate = LocalDate.now();
		if (currentDate.compareTo(productDiscountExpiryDate) >= 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean productBrandName(String productBrandName) {
		pattern = Pattern.compile("[a-zA-Z0-9]+");
		matcher = pattern.matcher(productBrandName);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailValidation(String email) {
		pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
