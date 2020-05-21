package com.infy.accountservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.infy.accountservice.exception.AccountNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.accountservice.model.Account;
import com.infy.accountservice.service.AccountDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountDetailsController.class)
public class AccountDetailsControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	private AccountDetailsService accountDetailsService;

	@Test
	public void getAccountDetailsByAccount() throws Exception{
		when(accountDetailsService.getAccountDetailsByAccount(anyString())).thenReturn(new Account("1","704597","SrujanKumar",29,700000,900));
		MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/accountDetails/account/704597")).andExpect(status().isOk()).andReturn();
		ObjectMapper mapper=new ObjectMapper();
		Account account= mapper.readerFor(Account.class).readValue(mvcResult.getResponse().getContentAsString());
		assertThat(account.getAccountNumber()).isEqualTo("704597");
	}
	@Test(expected = AccountNotFoundException.class)
	public void getAccountDetailsByAccountNotFound() throws Exception {
		when(accountDetailsService.getAccountDetailsByAccount(Mockito.anyString()))
				.thenThrow(new AccountNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/accountDetails/account/704520")).andExpect(status().isNotFound()).andReturn();

	}
}
