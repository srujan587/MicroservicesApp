package com.infy.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.homeloan.client.LoanEligibilityFeignClient;
import com.infy.homeloan.service.HomeLoanService;

@RestController
@RequestMapping("/homeloan")
public class HomeLoanController {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public LoanEligibilityFeignClient loanEligibilityClient;
	
	@Autowired
	private HomeLoanService homeLoanService;
	
	@RequestMapping("/checkEligibility/{accountNumber}")
	public String homeloan(@PathVariable("accountNumber") String accountNumber) {
		logger.info("Inside Home Loan Service");
		return loanEligibilityClient.getLoanEligibility(accountNumber);
	}
	
	@RequestMapping("/findAccount/{accountNumber}")
	public String findAccount(@PathVariable("accountNumber") String accountNumber) {
		logger.info("HomeLoanController::findAccount::Inside Home Loan Service");
		return homeLoanService.findAccount(accountNumber);
	}

}
