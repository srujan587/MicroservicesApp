package com.infy.payrollservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.payrollservice.model.Payroll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PayrollserviceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void getPayrollDetails() {
		ResponseEntity<Payroll> response=restTemplate.getForEntity("/payrolldetails/payroll/704597", Payroll.class);
		Payroll payroll= response.getBody();
		assertThat(payroll.getAccountNumber()).isEqualTo("704597");
		assertThat(payroll.getIncome()).isEqualTo(50000);
	}

}
