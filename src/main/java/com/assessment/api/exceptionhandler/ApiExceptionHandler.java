package com.assessment.api.exceptionhandler;

public class ApiExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ApiExceptionHandler(String message) {
		super(message);
	}

}