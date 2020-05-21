package com.infy.auditservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;

import com.infy.auditservice.model.Loan;

public interface LoanDetailsCustomRepositoty extends LoanDetailsRepository{
	
	@Query("{'loanAccountNumber' : ?0}")
	public Optional<List<Loan>> getLoansByLoanAccount(String loanAccountNumber);
}
