package com.example.bankaccountmanagementsystem;

import java.util.LinkedList;
import java.util.List;

public abstract class BankAccount implements BankOperations {
    String accountNumber;
    String accountHolderName;
    double balance;
    LinkedList<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new LinkedList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        this.balance += amount;

        String timestamp = java.time.LocalDateTime.now().toString();
        Transaction transaction = new Transaction(amount, "Deposit", "Deposit to account", timestamp);
        transactionHistory.add(transaction);

        System.out.println("Deposit successful. New balance: " + this.balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        this.balance -= amount;

        String timestamp = java.time.LocalDateTime.now().toString();
        Transaction transaction = new Transaction(amount, "Withdrawal", "Standard withdrawal", timestamp);
        transactionHistory.add(transaction);

        System.out.println("Withdrawal successful. New balance: " + this.balance);
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + this.balance);
    }

    //  NEW METHOD: Returns all transactions
    public List<Transaction> getAllTransactions() {
        return transactionHistory;
    }
}
