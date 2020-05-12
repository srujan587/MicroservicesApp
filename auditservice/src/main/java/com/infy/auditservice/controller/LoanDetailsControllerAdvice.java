package com.infy.auditservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.infy.auditservice.exception.LoanAccountNotFoundException;

@ControllerAdvice
public class LoanDetailsControllerAdvice {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void loanAccountNotFound(LoanAccountNotFoundException ex) {
	}

}
