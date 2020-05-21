package com.infy.payrollservice.service;

import com.infy.payrollservice.exceptions.AccountNotFoundException;
import com.infy.payrollservice.model.Payroll;
import com.infy.payrollservice.repository.PayrollDetailsRepository;
import com.infy.payrollservice.service.impl.PayrollDetailsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PayrollServiceDetailsTest {
    @Mock
    private PayrollDetailsRepository payrollDetailsRepository;
    private PayrollDetailsService payrollDetailsService;

    @Before
    public void setUp(){
        payrollDetailsService=new PayrollDetailsServiceImpl(payrollDetailsRepository);
    }

    @Test
    public void getPayrollDetailsByAccount(){
        when(payrollDetailsRepository.getPayrollDetailsByAccount(anyString())).thenReturn(new Payroll("1","704597","SrujanKumar","Salaried",50000.0,8));
        Payroll payroll=payrollDetailsService.getPayrollDetailsByAccount("704597");
        assertThat(payroll.getAccountNumber()).isEqualTo("704597");
        assertThat(payroll.getIncome()).isEqualTo(50000);
    }

    @Test(expected = AccountNotFoundException.class)
    public void getPayrollDetailsByAccountNotfound(){
        when(payrollDetailsRepository.getPayrollDetailsByAccount(anyString())).thenReturn(null);
        Payroll payroll=payrollDetailsService.getPayrollDetailsByAccount("704597");
    }
}
