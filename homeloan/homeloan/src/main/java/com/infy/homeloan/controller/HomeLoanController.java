package com.infy.homeloan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homeloan")
public class HomeLoanController {
	
	@RequestMapping("/home")
	public String homeloan() {
		return "Home Loan Service Invoked";
	}

}
