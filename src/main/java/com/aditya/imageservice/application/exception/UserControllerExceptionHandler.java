package com.aditya.imageservice.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aditya.imageservice.application.model.ErrorResponse;

@ControllerAdvice
public class UserControllerExceptionHandler 
{
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e)
	{
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(errorResponse);
	}
}
