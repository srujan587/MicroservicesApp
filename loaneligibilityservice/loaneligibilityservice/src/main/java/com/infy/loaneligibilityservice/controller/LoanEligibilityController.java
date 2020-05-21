package com.infy.loaneligibilityservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.loaneligibilityservice.client.AccountDetailsFeignClient;
import com.infy.loaneligibilityservice.client.PayrollDetailsFeignClient;

@RestController
@RequestMapping("/loaneligibility")
public class LoanEligibilityController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountDetailsFeignClient accountDetailsFeignClient;

	@Autowired
	private PayrollDetailsFeignClient payrollDetailsFeignClient;

	@RequestMapping("/geteligibility/{accountNumber}")
	public String getLoanEligibility(@PathVariable("accountNumber") String accountNumber) {
		logger.info("LoanEligibilityController::getLoanEligibility::enter");
		boolean eligibilityFromAccountDetails = accountDetailsFeignClient
				.getEligibilityFromAccountDetails(accountNumber);
		if (eligibilityFromAccountDetails) {
			boolean eligibilityFromPayrollDetails = payrollDetailsFeignClient
					.getEligibilityFromPayrollDetails(accountNumber);
			if (eligibilityFromPayrollDetails) {
				return "eligible";
			}
		}
		logger.info("LoanEligibilityController::getLoanEligibility::exit");
		return "ineligible";
	}

}
