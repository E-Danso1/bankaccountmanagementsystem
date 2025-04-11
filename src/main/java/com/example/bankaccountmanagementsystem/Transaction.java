package com.example.bankaccountmanagementsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Transaction {
    private double amount;
    private String type;        // "Deposit" or "Withdrawal"
    private String description;
    private String timestamp;

    // Constructor
    public Transaction(double amount, String type, String description, String timestamp) {
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
    }

    // Overloaded constructor with automatic timestamp
    public Transaction(double amount, String type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.timestamp = generateTimestamp();
    }

    // Method to generate current timestamp
    private String generateTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // Getters (optional, useful for UI)
    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // For displaying transaction history
    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + " of $" + amount + " - " + description;
    }
}
