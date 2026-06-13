package com.ujjwal.java.designpattern.Creational.FactoryPattern;

public class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment from Card:"+ amount);
    }
}

