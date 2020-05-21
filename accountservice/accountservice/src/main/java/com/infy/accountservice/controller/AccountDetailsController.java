package com.infy.accountservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.accountservice.model.Account;
import com.infy.accountservice.service.AccountDetailsService;

@RestController
@RequestMapping("/accountdetails")
public class AccountDetailsController {
	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AccountDetailsService accountDetailsService;

	@RequestMapping("/accountObj/{accountNumber}")
	public Account getAccountService(@PathVariable("accountNumber") String accountNumber) {
		logger.info("Inside AccountDetails Controller");
		return accountDetailsService.getAccountDetailsByAccount(accountNumber);
	}
	
	@RequestMapping("/account/{accountNumber}")
	public boolean getAccountServiceNew(@PathVariable("accountNumber") String accountNumber) {
		logger.info("AccountDetailsController::getAccountServiceNew::Inside AccountDetails Controller");
		return accountDetailsService.getAccountDetailsByAccountNew(accountNumber);
	}
}
