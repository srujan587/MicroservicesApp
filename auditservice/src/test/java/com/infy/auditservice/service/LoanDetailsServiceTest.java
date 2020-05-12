package com.infy.auditservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infy.auditservice.service.impl.LoanDetailsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.infy.auditservice.exception.LoanAccountNotFoundException;
import com.infy.auditservice.model.Loan;
import com.infy.auditservice.repository.LoanDetailsCustomRepositoty;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
public class LoanDetailsServiceTest {

	@Mock
	private LoanDetailsCustomRepositoty loanDetailsRepository;

	private LoanDetailsService loanDetailsService;
	@Before
	public void setUp(){
		loanDetailsService=new LoanDetailsServiceImpl(loanDetailsRepository);
	}

	@Test
	public void getLoansByLoanAccount() {

		Stream<Loan> listOfLoanStream = Arrays.stream(new Loan[] {
				new Loan("5ea7fd8adbd71a888a0dc805", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
						LocalDateTime.now()),
				new Loan("5ea7fd8adbd71a888a0dc805", "704597", "Personal", new BigDecimal(500000), new BigDecimal(5000),
						LocalDateTime.now()) });

		Mockito.when(loanDetailsRepository.getLoansByLoanAccount(Mockito.anyString()))
				.thenReturn(listOfLoanStream.collect(Collectors.toList()));
		List<Loan> listOfLoans = loanDetailsService.getLoansByLoanAccount("704597");
		assertThat(listOfLoans.get(0).getLoanAccountNumber()).isEqualTo("704597");
	}
	
	@Test(expected = LoanAccountNotFoundException.class)
	public void loanAccountNotFound() throws Exception {
		Mockito.when(loanDetailsRepository.getLoansByLoanAccount(Mockito.anyString()))
				.thenReturn(null);
		loanDetailsService.getLoansByLoanAccount("704597");
	}

}
