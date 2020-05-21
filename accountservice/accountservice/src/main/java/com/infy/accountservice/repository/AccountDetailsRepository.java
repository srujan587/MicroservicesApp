package com.infy.accountservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.infy.accountservice.model.Account;

@Repository
public interface AccountDetailsRepository extends MongoRepository<Account, Long> {
    @Query("{'accountNumber' : ?0}")
    Optional<Account> getAccountDetailsByAccount(String accountNumber);

}
