package com.infy.auditservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infy.auditservice.dto.LoanDTO;

@Repository
public interface LoanDetailsRepository extends MongoRepository<LoanDTO, Long>{

}
