package com.infy.homeloan.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.homeloan.model.Account;

@Repository
public interface HomeLoanRepository extends MongoRepository<Account, Long>{
	
	@Query("{ 'accountNumber' : ?0}")
	Optional<Account> findByAccount(String accountNumber);
}
