package com.example.bankaccountmanagementsystem;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
                return;
            }

            this.balance += amount;

            // Add to transaction history
            String timestamp = java.time.LocalDateTime.now().toString();
            Transaction transaction = new Transaction(amount, "Deposit", "Deposit to account", timestamp);
            transactionHistory.add(transaction);

            System.out.println("Deposit successful. New balance: " + this.balance);
        }




    @Override
    public void withdraw(double amount) {
        double minimumBalance = 500.0;

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if ((balance - amount) < minimumBalance) {
            System.out.println("Cannot withdraw. Minimum balance of $" + minimumBalance + " must be maintained.");
            return;
        }

        this.balance -= amount;
        String timestamp = java.time.LocalDateTime.now().toString();
        transactionHistory.add(new Transaction(amount, "Withdrawal", "Savings withdrawal", timestamp));

        System.out.println("Withdrawal successful. New balance: " + this.balance);
    }



    public void checkBalance(double amount) {
        System.out.println("Current balance: $" + this.balance);
    }

}
