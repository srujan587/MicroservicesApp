package com.infy.auditservice.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.infy.auditservice.model.Loan;

@Repository
public class LoanDetailsMongoDBRepo {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Loan> getPersonalLoansByAccount(String loanAccountNumber) {
		logger.info("LoanDetailsMongoDBRepo::getPersonalLoansByAccount::entered");
		Query query = new Query();
		query.addCriteria(Criteria.where("loanAccountNumber").is(loanAccountNumber));
		List<Loan> listOfPersnoalLoans = mongoTemplate.find(query, Loan.class);
		logger.info("LoanDetailsMongoDBRepo::getPersonalLoansByAccount::Exit"+listOfPersnoalLoans);
		return listOfPersnoalLoans.stream().filter(loan -> loan.getTypeOfLoan().equals("Personal"))
				.collect(Collectors.toList());
	}

}
