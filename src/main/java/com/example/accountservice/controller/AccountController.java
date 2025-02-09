package com.example.accountservice.controller;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.TransactionStatus;
import com.example.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        if (account.getCustomerEmail() == null || !account.getCustomerEmail().contains("@")) {
            ErrorResponse errorResponse = new ErrorResponse(400, "Email is required field");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        
        TransactionStatus status = accountService.createAccount(account);
        return new ResponseEntity<TransactionStatus>(status, HttpStatus.valueOf(status.getTransactionStatusCode()));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Long customerNumber) {
        Optional<Account> account = accountService.getAccount(customerNumber);
        
        if (account.isPresent()) {
            List<AccountResponse.SavingsAccount> savingsAccounts = new ArrayList<>(); // Correct type
        // ... (Your logic to fetch savings accounts from the database)
        // Example (replace with your data):
        savingsAccounts.add(new AccountResponse.SavingsAccount(123L, "Savings", 500.00));

        AccountResponse response = new AccountResponse(account.get(), 302, "Customer Account found"); // Correct usage
        response.setSavings(savingsAccounts);  // Set the savings accounts in the response

        return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else { // If the account is not found
            ErrorResponse error = new ErrorResponse(404,"Customer not found");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404

        }
    }
}