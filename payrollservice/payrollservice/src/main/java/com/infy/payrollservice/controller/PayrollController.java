package com.infy.payrollservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.payrollservice.model.Payroll;
import com.infy.payrollservice.service.PayrollDetailsService;

@RestController
@RequestMapping("/payrolldetails")
public class PayrollController {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PayrollDetailsService payrollDetailsService;

	@RequestMapping("/payrollObj/{accountNumber}")
	public Payroll getPayrollDetailsByAccount(@PathVariable("accountNumber") String accountNumber) {
		logger.info("PayrollController::getPayrollDetailsByAccount::Inside PayrollDetails Controller");
		return payrollDetailsService.getPayrollDetailsByAccount(accountNumber);
	}

	@RequestMapping("/payroll/{accountNumber}")
	public boolean getPayrollDetailsByAccountNew(@PathVariable("accountNumber") String accountNumber) {
		logger.info("PayrollController::getPayrollDetailsByAccount::Inside PayrollDetails Controller");
		return payrollDetailsService.getPayrollDetailsByAccountNew(accountNumber);
	}

}
