package com.example.bankaccountmanagementsystem;

public class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {
        if (!isMature()) {
            System.out.println("Cannot withdraw before maturity date.");
            return;
        }

        // Optional: Fixed deposits are usually not partially withdrawn, just a one-time payout
        if (amount != balance) {
            System.out.println("You must withdraw the full amount after maturity.");
            return;
        }

        this.balance = 0;
        String timestamp = java.time.LocalDateTime.now().toString();
        transactionHistory.add(new Transaction(amount, "Withdrawal", "Fixed Deposit maturity withdrawal", timestamp));

        System.out.println("Withdrawal successful. Account closed.");
    }

    private boolean isMature() {
        return true;
    }


    @Override
    public void checkBalance(double amount) {

    }
}
