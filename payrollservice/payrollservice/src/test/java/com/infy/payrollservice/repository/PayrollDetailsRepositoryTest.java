package com.infy.payrollservice.repository;

import com.infy.payrollservice.model.Payroll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PayrollDetailsRepositoryTest {
    @Autowired
    private PayrollDetailsRepository payrollDetailsRepository;

    @Test
    public void getPayrollDetailsByAccount(){
        Payroll payroll=payrollDetailsRepository.getPayrollDetailsByAccount("704597");
        assertThat(payroll.getAccountNumber()).isEqualTo("704597");
        assertThat(payroll.getIncome()).isEqualTo(50000);
    }

    @Test
    public void getAllPayrollDetails(){
        List<Payroll> payroll=payrollDetailsRepository.findAll();
        List<Payroll> listOfEligiblePayrolls=payroll.stream().filter((payrollDetails)->{
            return (payrollDetails.getDurationOfEmployment() > 2 && payrollDetails.getIncome() > 20000);
        }).collect(Collectors.toList());
        assertThat(listOfEligiblePayrolls.get(0).getDurationOfEmployment()).isGreaterThan(2);
        assertThat(listOfEligiblePayrolls.get(0).getIncome()).isGreaterThan(20000);
    }
}
