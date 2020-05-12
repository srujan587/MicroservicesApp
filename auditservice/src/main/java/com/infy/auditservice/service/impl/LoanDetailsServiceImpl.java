package com.infy.auditservice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.auditservice.exception.LoanAccountNotFoundException;
import com.infy.auditservice.model.Loan;
import com.infy.auditservice.repository.LoanDetailsCustomRepositoty;
import com.infy.auditservice.repository.LoanDetailsMongoDBRepo;
import com.infy.auditservice.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoanDetailsCustomRepositoty loanDetailsRepository;
	
	@Autowired
	private LoanDetailsMongoDBRepo loanDetailsMongoDBRepo;

	public LoanDetailsServiceImpl(LoanDetailsCustomRepositoty loanDetailsRepository) {
		this.loanDetailsRepository=loanDetailsRepository;
	}

	public void insertLoanDetails(Loan loan) {
		logger.info("LoanDetailsServiceImpl::insertLoanDetails invoked");
		loanDetailsRepository.insert(loan);
	}

	public List<Loan> getLoansByLoanAccount(String loanAccountNumber) {
		logger.info("LoanDetailsServiceImpl::getLoansByLoanAccount ::Enter");
		List<Loan> listOfLoans = loanDetailsRepository.getLoansByLoanAccount(loanAccountNumber);
		if (null == listOfLoans) {
			throw new LoanAccountNotFoundException();
		}
		logger.info("LoanDetailsServiceImpl::getLoansByLoanAccount ::Exit");
		return listOfLoans;
	}

	public List<Loan> getAllLoans() {
		logger.info("LoanDetailsServiceImpl::getAllLoans ::Enter");
		List<Loan> listOfLoans = loanDetailsRepository.findAll();
		if (null == listOfLoans) {
			throw new LoanAccountNotFoundException();
		}
		logger.info("LoanDetailsServiceImpl::getAllLoans ::Exit");
		return listOfLoans;
	}
	
	public void deleteLoan(String id) {
		logger.info("LoanDetailsServiceImpl::deleteLoan ::Enter");
		loanDetailsRepository.deleteById(new Long(id));
		logger.info("LoanDetailsServiceImpl::deleteLoan ::Exit");
	}
	
	public List<Loan> getPersonalLoansByAccount(String loanAccountNumber){
		logger.info("LoanDetailsServiceImpl::getPersonalLoansByAccount ::Invoked");
		return loanDetailsMongoDBRepo.getPersonalLoansByAccount(loanAccountNumber);
	}
}
