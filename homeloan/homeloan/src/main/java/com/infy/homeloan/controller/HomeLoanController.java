package com.infy.homeloan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.homeloan.client.LoanEligibilityFeignClient;

@RestController
@RequestMapping("/homeloan")
public class HomeLoanController {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public LoanEligibilityFeignClient loanEligibilityClient;
	
	@RequestMapping("/home")
	public String homeloan() {
		logger.info("Inside Home Loan Service");
		return loanEligibilityClient.getLoanEligibilityClient();
	}

}
