package com.ujjwal.java.exception.custom;

public class CustomExceptionDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(7000);
        } catch (InvalidBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

