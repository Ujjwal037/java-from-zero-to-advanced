package com.ujjwal.java.designpattern.Creational.BuilderPattern;

public class Main {

    public static void main(String[] args) {

        User user = new User.Builder()
                .firstName("Ujjwal")
                .lastName("Gupta")
                .email("ujjwal@gmail.com")
                .phone("9876543210")
                .build();
    }
}

//Builder Pattern: - Separates the construction of a complex object, from its representation so that the same, construction process can create different representations.
//Simplified: - Build an object step-by-step.
//Core Idea Instead of:
//new User(...)
//we do:  User user = new User.Builder()
//        .firstName("Ujjwal")
//        .email("ujjwal@gmail.com")
//        .phone("9876543210")
//        .build();
//Much cleaner.
//Builder Pattern consists of:  //Product
                                //Builder
                                //Concrete Builder
                                //Director (Optional)
                                //Client
//Execution Flow: Client
                //   ↓
                //Builder Object
                //   ↓
                //Set Values
                //   ↓
                //build()
                //   ↓
                //Product Object
//Example: .firstName("Ujjwal")
//         .email("abc@gmail.com")
//stores values inside Builder.
//Then: - build()
//creates the final User object.