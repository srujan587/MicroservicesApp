package com.infy.loaneligibilityservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loaneligibility")
public class LoanEligibilityController {
	
	@RequestMapping("/geteligibility")
	public String getLoanEligibility() {
		return "Loan ELigibility Invoked";
	}

}
