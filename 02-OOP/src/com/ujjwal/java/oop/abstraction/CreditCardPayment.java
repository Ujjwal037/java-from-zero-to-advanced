package com.ujjwal.java.oop.abstraction;

public class CreditCardPayment extends OnlinePayment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

