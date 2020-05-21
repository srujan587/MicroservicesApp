package com.infy.auditservice.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.infy.auditservice.exception.LoanAccountNotFoundException;
import com.infy.auditservice.model.Loan;

@Repository
public class LoanDetailsMongoDBRepo {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Loan> getPersonalLoansByAccount(String loanAccountNumber) throws LoanAccountNotFoundException{
		Query query = new Query();
		query.addCriteria(Criteria.where("loanAccountNumber").is(loanAccountNumber));
		List<Loan> listOfPersnoalLoans = mongoTemplate.find(query, Loan.class);
		Optional<List<Loan>> optionalListOfLoans=Optional.of(listOfPersnoalLoans);
		if(optionalListOfLoans.isPresent()) {
			if(optionalListOfLoans.get().size()==0)
				throw new LoanAccountNotFoundException();
		}
		return optionalListOfLoans.get().stream().filter(loan -> loan.getTypeOfLoan().equals("Personal"))
				.collect(Collectors.toList());
	}

}
