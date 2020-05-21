package com.infy.loaneligibilityservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountDetailsFeignClient {

    @RequestMapping("/accountdetails/account/{accountNumber}")
    public boolean getEligibilityFromAccountDetails(@PathVariable("accountNumber") String accountNumber);
}
