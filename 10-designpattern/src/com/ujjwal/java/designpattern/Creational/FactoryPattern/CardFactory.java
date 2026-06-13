package com.ujjwal.java.designpattern.Creational.FactoryPattern;

import javax.smartcardio.Card;

public class CardFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CardPayment();
    }
}
