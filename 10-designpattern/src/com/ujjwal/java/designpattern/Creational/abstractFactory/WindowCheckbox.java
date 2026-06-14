package com.ujjwal.java.designpattern.Creational.abstractFactory;

import java.awt.*;

public class WindowCheckbox implements CheckBox {
    @Override
    public void check() {
        System.out.println("WindowCheckbox");
    }
}
