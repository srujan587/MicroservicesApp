package com.infy.payrollservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.infy.payrollservice.exceptions.AccountNotFoundException;
import com.infy.payrollservice.model.Payroll;
import com.infy.payrollservice.repository.PayrollDetailsRepository;
import com.infy.payrollservice.service.PayrollDetailsService;

@Service
public class PayrollDetailsServiceImpl implements PayrollDetailsService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private PayrollDetailsRepository payrollDetailsRepository;

	public PayrollDetailsServiceImpl(PayrollDetailsRepository payrollDetailsRepository) {
		this.payrollDetailsRepository = payrollDetailsRepository;
	}

	@Override
	public Payroll getPayrollDetailsByAccount(String accountNumber) {
		logger.info("PayrollDetailsServiceImpl::getPayrollDetailsByAccount::Entered");
		Payroll payroll = payrollDetailsRepository.getPayrollDetailsByAccount(accountNumber);
		if (null == payroll) {
			throw new AccountNotFoundException();
		}
		logger.info("PayrollDetailsServiceImpl::getPayrollDetailsByAccount::Exit");
		return payroll;
	}

	public boolean getPayrollDetailsByAccountNew(String accountNumber) {
		logger.info("PayrollDetailsServiceImpl::getPayrollDetailsByAccount::Entered");
		boolean eligibility = false;
		Payroll payroll = payrollDetailsRepository.getPayrollDetailsByAccount(accountNumber);
		if (null == payroll) {
			throw new AccountNotFoundException();
		}
		if (payroll.getIncome() >= 25000 && payroll.getDurationOfEmployment() >= 2)
			eligibility = true;
		logger.info("PayrollDetailsServiceImpl::getPayrollDetailsByAccount::Exit");
		return eligibility;
	}
}
