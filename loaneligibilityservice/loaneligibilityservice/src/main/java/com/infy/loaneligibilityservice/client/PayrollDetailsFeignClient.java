package com.infy.loaneligibilityservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("payroll-service")
public interface PayrollDetailsFeignClient {

    @RequestMapping("/payrolldetails/payroll/{accountNumber}")
    public boolean getEligibilityFromPayrollDetails(@PathVariable("accountNumber") String accountNumber);
}
