package com.capgemini.capstore.exception;

@SuppressWarnings("serial")
public class CapstoreCustomException extends RuntimeException {

	String message;

	public CapstoreCustomException(String message) {
		super(message);
	}
}
