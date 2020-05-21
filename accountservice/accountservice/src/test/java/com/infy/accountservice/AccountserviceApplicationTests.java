package com.infy.accountservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.infy.accountservice.exception.AccountNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.accountservice.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountserviceApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAccountDetailsByAccount() {
		ResponseEntity<Account> response=this.restTemplate.getForEntity("/accountdetails/accountObj/704597", Account.class);
		Account account=response.getBody();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(account.getAccountNumber()).isEqualTo("704597");
		assertThat(account.getName()).isEqualTo("SrujanKumar");
	}
}
