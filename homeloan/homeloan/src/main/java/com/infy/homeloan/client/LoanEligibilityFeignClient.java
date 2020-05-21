package com.infy.homeloan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("loan-eligibility-service")
public interface LoanEligibilityFeignClient {
	
	@RequestMapping("/loaneligibility/geteligibility/{accountNumber}")
	public String getLoanEligibility(@PathVariable("accountNumber") String accountNumber);
}
