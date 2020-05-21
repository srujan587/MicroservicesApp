package com.infy.accountservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.infy.accountservice.exception.AccountNotFoundException;
import com.infy.accountservice.model.Account;
import com.infy.accountservice.repository.AccountDetailsRepository;
import com.infy.accountservice.service.impl.AccountDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountDetailsServiceTest {

    @Mock
    private AccountDetailsRepository accountDetailsRepository;

    private AccountDetailsService accountDetailsService;
    @Before
    public void setUp(){
        accountDetailsService=new AccountDetailsServiceImpl(accountDetailsRepository);
    }
    @Test
    public void getAccountDetailsByAccount(){
        Mockito.when(accountDetailsRepository.getAccountDetailsByAccount(anyString())).thenReturn(Optional.of(new Account("1","704597","SrujanKumar",29,700000,900)));
        Account account=accountDetailsService.getAccountDetailsByAccount("704597");
        assertThat(account.getAccountNumber()).isEqualTo("704597");
    }

    @Test(expected = AccountNotFoundException.class)
    public void getAccountDetailsByAccountNotFound(){
        Mockito.when(accountDetailsRepository.getAccountDetailsByAccount(anyString())).thenThrow(new AccountNotFoundException());
        Account account=accountDetailsService.getAccountDetailsByAccount("704520");
    }
}
