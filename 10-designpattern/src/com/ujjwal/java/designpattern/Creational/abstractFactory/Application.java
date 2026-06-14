package com.ujjwal.java.designpattern.Creational.abstractFactory;

import java.awt.*;

public class Application {

    private final button button;
    private final TextBox textBox;
    private final CheckBox checkbox;

    public Application(GUIFactory factory) {

        this.button = factory.createButton();
        this.textBox = factory.createTextBox();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {

        button.render();
        textBox.show();
        checkbox.check();
    }
}

//Abstract Factory Pattern :- Provides an interface for creating families,of related or dependent objects without ,specifying their concrete classes.

//Why Factory Method Is Not Enough
//Factory Method creates: One product at a time
//Example: Button button = buttonFactory.createButton();
//But now we need: A family of related objects
//Such as: Button ,TextBox, Checkbox  belonging to the same theme.

//Core Idea
//Factory Method: Creates ONE product
//Abstract Factory: Creates MULTIPLE related products
//5. Components Abstract Factory consists of:
//Abstract Products
//Concrete Products
//Abstract Factory
//Concrete Factory
//Client

//Class Diagram : -
//                                  GUIFactory
//                                         ↑
//                             ----------------------------
//                             |                          |
//                    WindowsFactory                MacFactory
//
//                            ↓                             ↓
//
//                        WindowsButton              MacButton
//                        WindowsTextBox             MacTextBox
//                        WindowsCheckbox            MacCheckbox