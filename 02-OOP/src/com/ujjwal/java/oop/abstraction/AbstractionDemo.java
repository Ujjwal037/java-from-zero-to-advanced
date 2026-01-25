package com.ujjwal.java.oop.abstraction;

public class AbstractionDemo {

    public static void main(String[] args) {

        Payment payment = new CreditCardPayment();
        payment.pay(5000);

        OnlinePayment online = new CreditCardPayment();
        online.paymentGateway();
    }
}

