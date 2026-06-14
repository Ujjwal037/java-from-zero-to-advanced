package com.ujjwal.java.designpattern.Creational.FactoryPattern;

public abstract class PaymentFactory {
    public abstract Payment createPayment();
}

//Factory Pattern :-  Define an interface for creating objects,but let subclasses decide which object to create.
//Simple Factory vs Factory Method : - Simple Factory uses one class ,Factory Method uses inheritance and polymorphism.
//Factory Method VS Abstract Factory : - Factory Method creates ONE product, Abstract Factory creates FAMILY of products.