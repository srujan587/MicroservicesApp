package com.infy.payrollservice.repository;

import com.infy.payrollservice.model.Payroll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollDetailsRepository extends MongoRepository<Payroll,Long> {
    @Query("{ 'accountNumber':?0}")
    Payroll getPayrollDetailsByAccount(String accountNumber);
}
