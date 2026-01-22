package com.ujjwal.java.oop.encapsulation;

public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Ujjwal", 1000);

        account.deposit(500);
        account.withdraw(300);

        System.out.println("Holder: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());
    }
}

