package org.jsp.eventmanagement.exceptionhandler;

import org.jsp.eventmanagement.exceptionclasses.NoEventFoundException;
import org.jsp.eventmanagement.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EventExceptionHandler {
	
	@ExceptionHandler(NoEventFoundException.class)
	public ResponseEntity<?> handleNoEventFoundException(NoEventFoundException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("No Event Present in Database table").body(e.getMessage()).build());
	}
	
	
	
	
}
