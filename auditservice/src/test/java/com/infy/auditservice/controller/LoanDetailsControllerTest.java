package com.infy.auditservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.auditservice.exception.LoanAccountNotFoundException;
import com.infy.auditservice.model.Loan;
import com.infy.auditservice.service.LoanDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanDetailsController.class)
public class LoanDetailsControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LoanDetailsService loanDetailsService;

	@Test
	public void getLoansByAccountNumber() throws Exception {

		Stream<Loan> listOfLoanStream = Arrays.stream(new Loan[] {
				new Loan("5ea7fd8adbd71a888a0dc805", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
						LocalDateTime.now()),
				new Loan("5ea7fd8adbd71a888a0dc805", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
						LocalDateTime.now()) });

		Mockito.when(loanDetailsService.getLoansByLoanAccount(Mockito.anyString()))
				.thenReturn(listOfLoanStream.collect(Collectors.toList()));

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/loandetails/getLoans/704597"))
				.andExpect(status().isOk()).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		List<Loan> listOfLoans = mapper.readValue(mvcResult.getResponse().getContentAsString(),
				new TypeReference<List<Loan>>() {
				});

		assertThat(listOfLoans.get(0).getLoanAccountNumber()).isEqualTo("704597");
	}

	@Test
	public void loanAccountNotFound() throws Exception {
		Mockito.when(loanDetailsService.getLoansByLoanAccount(Mockito.anyString()))
				.thenThrow(LoanAccountNotFoundException.class);
		mockMvc.perform(MockMvcRequestBuilders.get("/loandetails/getLoans/704597")).andExpect(status().isNotFound());
	}
}
