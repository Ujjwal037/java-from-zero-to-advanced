package com.ujjwal.java.designpattern.Creational.FactoryPattern;

public class UPIFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new UPIpayment();
    }
}
