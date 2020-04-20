package com.infy.payrollservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
	
	@RequestMapping("/getpayroll")
	public String getPayroll() {
		return "Payroll Service Invoked";
	}

}
