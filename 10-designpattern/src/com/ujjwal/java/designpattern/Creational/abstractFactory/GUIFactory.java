package com.ujjwal.java.designpattern.Creational.abstractFactory;

import java.awt.*;

public interface GUIFactory {
    button createButton();
    CheckBox createCheckbox();
    TextBox createTextBox();
}
