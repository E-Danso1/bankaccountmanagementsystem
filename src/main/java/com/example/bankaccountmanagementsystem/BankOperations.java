package com.example.bankaccountmanagementsystem;

public interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance(double amount);
}
