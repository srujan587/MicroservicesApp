package com.infy.accountservice.service;

import com.infy.accountservice.exception.AccountNotFoundException;
import com.infy.accountservice.model.Account;

public interface AccountDetailsService {

	public boolean getAccountDetailsByAccountNew(String accountNumber) throws AccountNotFoundException;
	public Account getAccountDetailsByAccount(String accountNumber) throws AccountNotFoundException;

}
