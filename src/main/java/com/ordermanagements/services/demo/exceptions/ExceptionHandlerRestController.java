package com.ordermanagements.services.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController

public class ExceptionHandlerRestController {
	
	    @ExceptionHandler(CustomerNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleCustomerNotFoundException(CustomerNotFoundException ex,WebRequest req){
	        ErrorDetails details=new ErrorDetails("customer is not found", LocalDateTime.now());
	        return new ResponseEntity<ErrorDetails> (details,HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(OrderNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException ex,WebRequest req){
	        ErrorDetails details=new ErrorDetails("Order is not found", LocalDateTime.now());
	        return new ResponseEntity<ErrorDetails> (details,HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorDetails> allException(Exception ex,WebRequest req){
	        ErrorDetails details=new ErrorDetails("you entered wrong details", LocalDateTime.now());
	        return new ResponseEntity<ErrorDetails> (details,HttpStatus.BAD_REQUEST);
	    }

	 

	}

