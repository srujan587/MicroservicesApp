package com.infy.auditservice.service;

import java.util.List;

import com.infy.auditservice.model.Loan;


public interface LoanDetailsService {
	
	public void insertLoanDetails(Loan loan);
	public List<Loan> getLoansByLoanAccount(String loanAccountNumber);
	public List<Loan> getAllLoans();
	public void deleteLoan(String id);
	public List<Loan> getPersonalLoansByAccount(String loanAccountNumber);

}
