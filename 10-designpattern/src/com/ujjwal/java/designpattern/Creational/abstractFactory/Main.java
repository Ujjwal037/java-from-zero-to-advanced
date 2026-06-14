package com.ujjwal.java.designpattern.Creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new WindowFactory();
        Application application = new Application(factory);
        application.renderUI();

    }
}
