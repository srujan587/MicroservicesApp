package com.infy.auditservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infy.auditservice.model.Loan;

@Repository
public interface LoanDetailsRepository extends MongoRepository<Loan, Long>{

}
