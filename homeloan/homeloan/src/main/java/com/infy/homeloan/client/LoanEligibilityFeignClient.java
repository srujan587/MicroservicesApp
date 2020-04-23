package com.infy.homeloan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("loan-eligibility-service")
public interface LoanEligibilityFeignClient {
	
	@RequestMapping("/loaneligibility/geteligibility")
	public String getLoanEligibilityClient();
}
