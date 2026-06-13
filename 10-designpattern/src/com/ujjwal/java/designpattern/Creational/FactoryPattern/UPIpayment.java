package com.ujjwal.java.designpattern.Creational.FactoryPattern;

public class UPIpayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment from UPI:"+ amount);

    }
}
