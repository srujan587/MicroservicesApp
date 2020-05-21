package com.infy.auditservice;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.infy.auditservice.model.Loan;

public class AuditServiceWireMockServerTest {

	private RestTemplate restTemplate;

	public static WireMockServer wireMockServer = new WireMockServer(8081);

	@BeforeAll
	static void setup() {
		wireMockServer.start();
	}

	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	@AfterEach
	void after() {
		wireMockServer.resetAll();
	}

	@AfterAll
	static void clean() {
		wireMockServer.shutdown();
	}

	@Test
	void getLoansByAccountTest() throws Exception {
		wireMockServer.stubFor(get(urlEqualTo("/loandetails/getLoans/704597")).willReturn(
				aResponse().withStatus(HttpStatus.OK.value()).withHeader("Content-Type", "application/json").withBody(
						"[{\"id\": \"1\",\"loanAccountNumber\": \"704597\"},{\"id\": \"2\",\"loanAccountNumber\": \"704597\"}]")));

		ResponseEntity<Loan[]> response = restTemplate.getForEntity("http://localhost:8081/loandetails/getLoans/704597",
				Loan[].class);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
		for (Loan loan : response.getBody()) {
			assertThat(loan.getLoanAccountNumber()).isEqualTo("704597");
		}
		wireMockServer.verify(getRequestedFor(urlMatching("/loandetails/getLoans/704597")));
	}

	@Test
	void insertLoanTest() {
		wireMockServer.stubFor(
				post(urlEqualTo("/loandetails/insertLoan")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
						.withHeader("Content-Type", "application/json").withBody("Loan inserted Successfully")));
		Loan loanRequest = new Loan("4", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
				LocalDateTime.now());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Loan> httpEntity = new HttpEntity<Loan>(httpHeaders);
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8081/loandetails/insertLoan",
				HttpMethod.POST, httpEntity, String.class, loanRequest);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
	}
}
