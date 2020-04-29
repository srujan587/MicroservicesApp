package com.infy.auditservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.auditservice.dto.LoanDTO;
import com.infy.auditservice.model.Loan;
import com.infy.auditservice.repository.LoanDetailsCustomRepositoty;
import com.infy.auditservice.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {
	
	@Autowired
	private LoanDetailsCustomRepositoty loanDetailsRepository;
	
	public void insertLoanDetails(Loan loan) {
		LoanDTO loanDTO=new LoanDTO();
		if(null!=loan){
			loanDTO.setLoanAccountNumber(loan.getLoanAccountNumber());
			loanDTO.setTypeOfLoan(loan.getTypeOfLoan());
			loanDTO.setLoanAmount(new Decimal128(loan.getLoanAmount()));
			loanDTO.setEmi(new Decimal128(loan.getEmi()));
			loanDTO.setCreated_on(LocalDateTime.now());
		}		
		loanDetailsRepository.insert(loanDTO);
	}

	public List<Loan> getLoansByLoanAccount(String loanAccountNumber){
		return loanDetailsRepository.getLoansByLoanAccount(loanAccountNumber);
	}
}
