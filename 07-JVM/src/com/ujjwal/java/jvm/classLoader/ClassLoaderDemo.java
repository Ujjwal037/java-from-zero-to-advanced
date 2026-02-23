package com.ujjwal.java.jvm.classLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) {

        ClassLoader appLoader =
                ClassLoaderDemo.class.getClassLoader();

        System.out.println("Application Loader: " + appLoader);

        System.out.println("Parent Loader: " +
                appLoader.getParent());

        System.out.println("Bootstrap Loader: " +
                appLoader.getParent().getParent());
    }
}

//What Happens When You Run a Java Program?
//
//When you run:
//
//java MyApp
//
//JVM does NOT directly execute .java.
//
//        It:
//
//Loads .class file
//
//Verifies bytecode
//
//        Allocates memory for class metadata
//
//Initializes static variables
//
//Executes main()
//
//All this happens via:
//
//ClassLoader subsystem
//
//🧠 What Is ClassLoader?
//
//A ClassLoader is responsible for:
//
//Loading class bytecode into memory
//
//        Converting bytecode → Class object
//
//Linking and initializing classes
//
//Part of the JVM runtime.
//
//🏗 Class Loading Phases
//
//When a class is loaded, it goes through 3 main stages:
//
//        1️⃣ Loading
//2️⃣ Linking
//3️⃣ Initialization
//1️⃣ Loading
//
//Read .class file
//
//Create Class object in memory
//
//        Store in Metaspace
//
//2️⃣ Linking
//
//Linking has 3 sub-phases:
//
//a) Verification
//
//Bytecode correctness check
//
//Security validation
//
//b) Preparation
//
//Allocate memory for static variables
//
//Default values assigned
//
//Example:
//
//static int x = 10;
//
//During preparation:
//
//x = 0
//c) Resolution
//
//Replace symbolic references
//
//Convert into direct memory references
//
//3️⃣ Initialization
//
//Execute static blocks
//
//Assign actual static values
//
//Now:
//
//x = 10
//        🔥 ClassLoader Hierarchy
//
//Java uses hierarchical class loading:
//
//Bootstrap ClassLoader
//        ↓
//Platform (Extension) ClassLoader
//        ↓
//Application ClassLoader
//1️⃣ Bootstrap ClassLoader
//
//Loads core classes from:
//
//rt.jar / Java base modules
//
//Examples:
//
//java.lang.String
//
//java.util.*
//
//Written in native C/C++.
//
//        2️⃣ Platform ClassLoader
//
//Loads:
//
//Extension libraries
//
//JDK internal APIs
//
//3️⃣ Application ClassLoader
//
//Loads:
//
//Classes from classpath
//
//Your project classes
//
//🔁 Parent Delegation Model
//
//This is VERY IMPORTANT.
//
//When class is requested:
//
//Ask parent loader
//
//Parent asks its parent
//
//Bootstrap tries first
//
//If not found, child loads
//
//This ensures:
//
//Core Java classes cannot be overridden
//
//Security
//
//        Consistency
//
//Example:
//
//You cannot replace:
//
//java.lang.String
//
//Because bootstrap loads it first.
