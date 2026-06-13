package com.ujjwal.java.designpattern.Creational.FactoryPattern;

public class DemoOfFactory {
    public static void main(String[] args) {
        PaymentFactory factory = new UPIFactory();
        Payment payment = factory.createPayment();
        payment.pay(500);
    }

}

