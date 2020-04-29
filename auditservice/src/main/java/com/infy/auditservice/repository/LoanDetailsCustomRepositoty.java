package com.infy.auditservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

public interface LoanDetailsCustomRepositoty extends LoanDetailsRepository{
	
	@Query("{'loanAccountNumber' : ?0}")
	public List getLoansByLoanAccount(String loanAccountNumber);
}
