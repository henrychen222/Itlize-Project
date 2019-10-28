package com.joole.exception;

public class ProductException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public ProductException() {
		super();
	}
	
	public ProductException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}

	
}
