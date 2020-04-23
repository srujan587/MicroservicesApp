package com.infy.loaneligibilityservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loaneligibility")
public class LoanEligibilityController {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/geteligibility")
	public String getLoanEligibility() {
		logger.info("Inside Loan Eligibility Service");
		return "Loan ELigibility Invoked";
	}

}
