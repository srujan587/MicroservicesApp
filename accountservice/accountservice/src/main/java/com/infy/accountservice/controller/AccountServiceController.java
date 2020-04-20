package com.infy.accountservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountservice")
public class AccountServiceController {

	@RequestMapping("/account")
	public String getAccountService() {
		return "Account Services Invoked";
	}
}
