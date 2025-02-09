package com.example.accountservice.controller; // Or your package

import com.example.accountservice.model.Account; // Import your Account model
import java.util.List; // Import List
import java.util.ArrayList; // Import ArrayList

public class AccountResponse {
    private String customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<SavingsAccount> savings;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    // No-args constructor (IMPORTANT for JSON deserialization)
    public AccountResponse() {}

    public AccountResponse(Account account, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = String.valueOf(account.getCustomerNumber());
        this.customerName = account.getCustomerName();
        this.customerMobile = account.getCustomerMobile();
        this.customerEmail = account.getCustomerEmail();
        this.address1 = account.getAddress1();
        this.address2 = account.getAddress2();
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
        this.savings = new ArrayList<>(); // Initialize savings list
    }

    // Getters and setters for all fields (IMPORTANT for JSON serialization)
    public String getCustomerNumber() { return customerNumber; }
    public void setCustomerNubmer(Long customerNumber) { this.customerNumber = String.valueOf(customerNumber); }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerMobile() { return customerMobile; }
    public void setCustomerMobile(String customerMobile) { this.customerMobile = customerMobile; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }
    public String getAddress2() { return address2; }
    public void setaddress2(String address2) { this.address2 = address2; }
    public List<SavingsAccount> getSavings() { return savings; }
    public void setSavings(List<SavingsAccount> savings) { this.savings = savings; }
    public int getTransactionStatusCode() { return transactionStatusCode; }
    public void setTransactionStatusCode(int transactionStatusCode) { this.transactionStatusCode = transactionStatusCode; }
    public String getTransactionStatusDescription() { return transactionStatusDescription; }
    public void setTransactionStatusDescription(String transactionStatusDescription) { this.transactionStatusDescription = transactionStatusDescription; }


    // Inner class for SavingsAccount
    public static class SavingsAccount {
        private Long accountNumber;
        private String accountType;
        private double availableBalance;

        public SavingsAccount() {} // No-args constructor for JSON

        public SavingsAccount(Long accountNumber, String accountType, double availableBalance) {
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.availableBalance = availableBalance;
        }

        public Long getAccountNumber() { return accountNumber; }
        public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
        public String getAccountType() { return accountType; }
        public void setAccountType(String accountType) { this.accountType = accountType; }
        public double getAvailableBalance() { return availableBalance; }
        public void setAvailableBalance(double availableBalance) { this.availableBalance = availableBalance; }

    }
}