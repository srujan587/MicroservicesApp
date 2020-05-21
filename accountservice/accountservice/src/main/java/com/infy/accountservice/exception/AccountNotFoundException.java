package com.infy.accountservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AccountNotFoundException extends RuntimeException{

}
