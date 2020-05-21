package com.infy.auditservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.auditservice.exception.LoanAccountNotFoundException;
import com.infy.auditservice.model.Loan;
import com.infy.auditservice.repository.LoanDetailsCustomRepositoty;
import com.infy.auditservice.repository.LoanDetailsMongoDBRepo;
import com.infy.auditservice.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	private LoanDetailsCustomRepositoty loanDetailsRepository;

	@Autowired
	private LoanDetailsMongoDBRepo loanDetailsMongoDBRepo;

	public LoanDetailsServiceImpl(LoanDetailsCustomRepositoty loanDetailsRepository,
			LoanDetailsMongoDBRepo loanDetailsMongoDBRepo) {
		this.loanDetailsRepository = loanDetailsRepository;
		this.loanDetailsMongoDBRepo = loanDetailsMongoDBRepo;
	}

	public LoanDetailsServiceImpl() {

	}

	public void insertLoanDetails(Loan loan) {
		loanDetailsRepository.insert(loan);
	}

	public List<Loan> getLoansByLoanAccount(String loanAccountNumber) throws LoanAccountNotFoundException {
		Optional<List<Loan>> optionalListOfLoans = loanDetailsRepository.getLoansByLoanAccount(loanAccountNumber);
		if (optionalListOfLoans.isPresent()) {
			if (optionalListOfLoans.get().size() == 0)
				throw new LoanAccountNotFoundException();
		}
		return optionalListOfLoans.orElseThrow(() -> new LoanAccountNotFoundException());
	}

	public List<Loan> getAllLoans() {
		List<Loan> listOfLoans = loanDetailsRepository.findAll();
		Optional<List<Loan>> optionalListOfLoans = Optional.ofNullable(listOfLoans);
		return optionalListOfLoans.orElseThrow(() -> new LoanAccountNotFoundException());
	}

	public void deleteLoan(String id) {
		loanDetailsRepository.deleteById(new Long(id));
	}

	public List<Loan> getPersonalLoansByAccount(String loanAccountNumber) throws LoanAccountNotFoundException {
		List<Loan> listOfLoans = loanDetailsMongoDBRepo.getPersonalLoansByAccount(loanAccountNumber);
		Optional<List<Loan>> optionalListOfLoans = Optional.ofNullable(listOfLoans);
		if (optionalListOfLoans.isPresent()) {
			if (optionalListOfLoans.get().size() == 0)
				throw new LoanAccountNotFoundException();
		}
		return optionalListOfLoans.orElseThrow(() -> new LoanAccountNotFoundException());
	}
}
