package com.infy.accountservice.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.accountservice.exception.AccountNotFoundException;
import com.infy.accountservice.model.Account;
import com.infy.accountservice.repository.AccountDetailsRepository;
import com.infy.accountservice.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetailsServiceImpl(AccountDetailsRepository accountDetailsRepository) {
		this.accountDetailsRepository = accountDetailsRepository;
	}

	public Account getAccountDetailsByAccount(String accountNumber) throws AccountNotFoundException {
		logger.info("AccountDetailsServiceImpl::getAccountDetailsByAccount::Enter");
		final Optional<Account> account = accountDetailsRepository.getAccountDetailsByAccount(accountNumber);
		return account.orElseThrow(() -> new AccountNotFoundException());
	}

	public boolean getAccountDetailsByAccountNew(String accountNumber) throws AccountNotFoundException {
		logger.info("AccountDetailsServiceImpl::getAccountDetailsByAccount::Enter");
		boolean eligibility = false;
		Optional<Account> account = accountDetailsRepository.getAccountDetailsByAccount(accountNumber);
		if (account.isPresent()) {
			Account accountObj = account.get();
			if ((accountObj.getAge() >= 23 && accountObj.getAge() <= 65) && accountObj.getCibilScore() >= 650
					&& (accountObj.getLoanAmount() >= 35000 && accountObj.getLoanAmount() <= 500000))
				eligibility = true;
		} else {
			throw new AccountNotFoundException();
		}
		logger.info("AccountDetailsServiceImpl::getAccountDetailsByAccount::Exit" + eligibility);
		return eligibility;
	}
}
