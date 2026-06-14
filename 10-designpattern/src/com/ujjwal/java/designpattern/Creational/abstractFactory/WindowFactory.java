package com.ujjwal.java.designpattern.Creational.abstractFactory;

import java.awt.*;

public class WindowFactory implements GUIFactory{

    @Override
    public button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WindowCheckbox();
    }

    @Override
    public TextBox createTextBox() {
        return new WindowTextBox();
    }
}
