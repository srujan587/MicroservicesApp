package com.infy.loaneligibilityservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountDetailsFeignClient {

    @RequestMapping("/accountDetails/account/{accountNumber}")
    public String getAccountDetailsByAccount(@PathVariable("accountNumber") String accountNumber);
}
