package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.TransactionStatus;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public TransactionStatus createAccount(Account account) {
        TransactionStatus status = new TransactionStatus();

        

        // Generate a unique customer number (you might want a better strategy)
        long customerNumber = System.currentTimeMillis(); // Simple approach
        account.setCustomerNumber(customerNumber);

        accountRepository.save(account);

        status.setCustomerNumber(customerNumber);
        status.setTransactionStatusCode(HttpStatus.CREATED.value());
        status.setTransactionStatusDescription("Customer account created");
        return status;
    }

    public Optional<Account> getAccount(Long customerNumber) {
        return accountRepository.findByCustomerNumber(customerNumber);
    }
}