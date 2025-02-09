package com.example.accountservice.controller; // Or your package

public class ErrorResponse {
    private int transactionStatusCode; // Field to store the HTTP status code
    private String transactionStatusDescription; // Field to store the error message

    // Constructor to initialize the fields
    public ErrorResponse(int statusCode, String message) { 
        this.transactionStatusCode = statusCode;
        this.transactionStatusDescription = message;
    }

    // Getters for JSON serialization
    // Getter for transactionStatusCode
    public int getTransactionStatusCode() { 
        return transactionStatusCode;
    }

    // Getter for transactionStatusDescription
    public String getTransactionStatusDescription() { 
        return transactionStatusDescription;
    }
}