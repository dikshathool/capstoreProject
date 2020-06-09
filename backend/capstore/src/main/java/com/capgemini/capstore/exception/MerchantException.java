package com.capgemini.capstore.exception;

@SuppressWarnings("serial")
public class MerchantException extends RuntimeException{

	String message ;

	public MerchantException(String message) {
		super(message);
	}
}
