package com.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.ecommerce.service.ProductNotFoundException;
import com.ecommerce.ecommerce.service.ProductPriceNotFoundException;
@ControllerAdvice
public class ExceptionHandlerProductNotFound {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> ExceptionProductNotFound(ProductNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductPriceNotFoundException.class)
	public ResponseEntity<String>  ExceptionProductPriceNotFound(ProductPriceNotFoundException ex1)
	{
		return new ResponseEntity<>(ex1.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	

}
