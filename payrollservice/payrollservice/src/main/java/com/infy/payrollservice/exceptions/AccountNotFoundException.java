package com.infy.payrollservice.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AccountNotFoundException extends RuntimeException {
}
