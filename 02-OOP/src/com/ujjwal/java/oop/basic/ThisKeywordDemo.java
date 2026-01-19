package com.ujjwal.java.oop.basic;

public class ThisKeywordDemo {

    int value;

    ThisKeywordDemo(int value) {
        this.value = value;
    }

    void printValue() {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        ThisKeywordDemo obj = new ThisKeywordDemo(10);
        obj.printValue();
    }
}

