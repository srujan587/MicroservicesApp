package com.infy.auditservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.infy.auditservice.exception.LoanAccountNotFoundException;

@ControllerAdvice
public class ControllersAdvice {

	@ExceptionHandler(value = LoanAccountNotFoundException.class)
	@ResponseStatus (value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> loanAccountNotFound(LoanAccountNotFoundException ex) {
		return new ResponseEntity<String>("Loan Account not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<String>("Internal Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
