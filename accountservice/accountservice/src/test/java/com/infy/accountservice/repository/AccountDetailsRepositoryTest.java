package com.infy.accountservice.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.accountservice.exception.AccountNotFoundException;
import com.infy.accountservice.model.Account;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountDetailsRepositoryTest {
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	@Test
	public void getAccountDetailsByAccount() {
		Optional<Account> account = accountDetailsRepository.getAccountDetailsByAccount("704597");
		assertThat(account.get().getAccountNumber()).isEqualTo("704597");
	}

	@Test(expected = AccountNotFoundException.class)
	public void getAccountDetailsByAccountNotFound() {
		Optional<Account> account = accountDetailsRepository.getAccountDetailsByAccount("704520");
		account.orElseThrow(() -> new AccountNotFoundException());
	}

}
