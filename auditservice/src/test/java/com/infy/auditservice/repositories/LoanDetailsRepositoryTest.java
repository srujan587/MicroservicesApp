package com.infy.auditservice.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.auditservice.model.Loan;
import com.infy.auditservice.repository.LoanDetailsCustomRepositoty;

@RunWith(SpringRunner.class)
@DataMongoTest
public class LoanDetailsRepositoryTest {

	@Autowired
	private LoanDetailsCustomRepositoty loanDetailsRepository;

	@Test
	public void getLoansByAccount() throws Exception {

		List<Loan> listOfLoans = loanDetailsRepository.getLoansByLoanAccount("704597");
		assertThat(listOfLoans.get(0).getLoanAccountNumber()).isEqualTo("704597");
	}

	@Test
	public void insertLoan() throws Exception {
		Loan loan=new Loan("1", "704519", "Personal", new BigDecimal(500000), new BigDecimal(5000),
				LocalDateTime.now());
		Loan loaninserted = loanDetailsRepository.insert(loan);
		assertThat(loaninserted.getLoanAccountNumber()).isEqualTo("704597");
	}
}
