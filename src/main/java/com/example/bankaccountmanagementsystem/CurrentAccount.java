package com.example.bankaccountmanagementsystem;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {
        double overdraftLimit = 1000.0;

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if ((balance - amount) < -overdraftLimit) {
            System.out.println("Overdraft limit exceeded.");
            return;
        }

        this.balance -= amount;
        String timestamp = java.time.LocalDateTime.now().toString();
        transactionHistory.add(new Transaction(amount, "Withdrawal", "Current account withdrawal", timestamp));

        System.out.println("Withdrawal successful. New balance: " + this.balance);
    }


    public void checkBalance(double amount) {
        System.out.println("Current balance: $" + this.balance);
    }

}
