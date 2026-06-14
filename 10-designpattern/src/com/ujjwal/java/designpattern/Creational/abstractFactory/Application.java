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
