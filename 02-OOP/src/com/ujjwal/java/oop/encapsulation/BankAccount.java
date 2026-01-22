package com.ujjwal.java.oop.encapsulation;

public class BankAccount {

    private String accountHolderName;
    private double balance;

    public BankAccount(String name, double initialBalance) {
        this.accountHolderName = name;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

