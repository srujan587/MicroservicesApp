package com.infy.auditservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.auditservice.model.Loan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuditserviceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getLoansByAccountTest() throws Exception {
		ResponseEntity<Loan[]> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "/loandetails/getLoans/704597", Loan[].class);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
		for (Loan loan : response.getBody()) {
			assertThat(loan.getLoanAccountNumber()).isEqualTo("704597");
		}
	}

	@Test
	void insertLoanTest() {
		Loan loanRequest = new Loan("4", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
				LocalDateTime.now());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Loan> httpEntity = new HttpEntity<Loan>(httpHeaders);
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:" + port + "/loandetails/insertLoan",
				HttpMethod.POST, httpEntity,String.class,loanRequest);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
	}

}
