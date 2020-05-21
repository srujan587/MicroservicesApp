package com.infy.homeloan.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.homeloan.model.Account;
import com.infy.homeloan.repository.HomeLoanRepository;
import com.infy.homeloan.service.HomeLoanService;

@Service
public class HomeLoanServiceImpl implements HomeLoanService {

	@Autowired
	private HomeLoanRepository homeLoanRepository;

	@Override
	public String findAccount(String accountNumber) {
		// TODO Auto-generated method stub
		Optional<Account> account = homeLoanRepository.findByAccount(accountNumber);
		return account.isPresent() ? "Account Found" : "Account Not Found";
	}

}
