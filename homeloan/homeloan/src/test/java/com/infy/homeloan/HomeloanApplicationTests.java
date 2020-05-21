package com.infy.homeloan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HomeloanApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void findAccountByAccountNumber() {

		ResponseEntity<String> response = this.restTemplate.getForEntity("/homeloan/findAccount/704597", String.class);
		assertThat(response.getBody()).isEqualTo("Account Found");
	}

	@Test
	void findAccountByAccountNumberNotFound() {

		ResponseEntity<String> response = this.restTemplate.getForEntity("/homeloan/findAccount/704520", String.class);
		assertThat(response.getBody()).isEqualTo("Account Not Found");
	}
}
