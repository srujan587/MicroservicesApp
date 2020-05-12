package com.infy.auditservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class LoanAccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
