package com.ujjwal.java.designpattern.Creational.abstractFactory;

public class WindowTextBox implements TextBox {
    @Override
    public void show() {
        System.out.println("WindowButton");
    }
}
