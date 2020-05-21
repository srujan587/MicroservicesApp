package com.infy.payrollservice.service;

import com.infy.payrollservice.model.Payroll;

public interface PayrollDetailsService {
    Payroll getPayrollDetailsByAccount(String accountNumber);
    boolean getPayrollDetailsByAccountNew(String accountNumber);
}
