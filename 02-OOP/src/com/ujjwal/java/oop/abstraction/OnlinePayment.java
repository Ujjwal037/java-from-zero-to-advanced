package com.ujjwal.java.oop.abstraction;

public abstract class OnlinePayment implements Payment {

    public void paymentGateway() {
        System.out.println("Processing payment through online gateway");
    }
}

