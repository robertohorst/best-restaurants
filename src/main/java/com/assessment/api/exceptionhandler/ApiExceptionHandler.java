package com.assessment.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
				
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {
		
		var exceptionResponse = new MyErrorResponse();
		exceptionResponse.setStatus(400);
		exceptionResponse.setTitle("Parameter '" + ex.getName() + "' value should be "+ ex.getRequiredType().getSimpleName());
		exceptionResponse.setTime(LocalDateTime.now());

	    return new ResponseEntity<Object>(
	    		exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
