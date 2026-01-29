package com.ujjwal.java.exception.custom;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InvalidBalanceException {
        if (amount > balance) {
            throw new InvalidBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}
