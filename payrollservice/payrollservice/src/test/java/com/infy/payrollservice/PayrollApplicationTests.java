package com.infy.payrollservice;

import com.infy.payrollservice.model.Payroll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PayrollApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void getPayrollDetails() {
		ResponseEntity<Payroll> response=restTemplate.getForEntity("/payrolldetails/payroll/704597", Payroll.class);
		Payroll payroll= response.getBody();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(payroll.getAccountNumber()).isEqualTo("704597");
		assertThat(payroll.getIncome()).isEqualTo(50000);
	}

}
