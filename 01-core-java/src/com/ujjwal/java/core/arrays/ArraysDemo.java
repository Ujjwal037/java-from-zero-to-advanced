package com.ujjwal.java.core.arrays;

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {

        // 1. Declaration and Initialization
        // Syntax: dataType[] arrayName = new dataType[size];
        int[] numbers = new int[5]; // Creates an array of size 5, default values are 0
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Alternative: Inline Initialization
        String[] fruits = {"Apple", "Banana", "Cherry", "Mango"};

        System.out.println("--- Basic Array Access ---");
        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + fruits.length);

        // 2. Iterating through a 1D Array
        System.out.println("\n--- Iterating 1D Array (Standard For Loop) ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // 3. Enhanced For-Loop (For-Each)
        System.out.println("\n--- Iterating 1D Array (Enhanced For Loop) ---");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // 4. Multi-Dimensional Arrays (2D Array)
        // Think of it as a table with rows and columns
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("\n--- Iterating 2D Array ---");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // New line after each row
        }

        // 5. Common Array Operations using java.util.Arrays Utility
        System.out.println("\n--- Arrays Utility Methods ---");

        // Sorting
        int[] unsorted = {50, 10, 40, 20, 30};
        Arrays.sort(unsorted);
        System.out.println("Sorted Array: " + Arrays.toString(unsorted));

        // Binary Search (Array must be sorted first)
        int index = Arrays.binarySearch(unsorted, 40);
        System.out.println("Index of element 40: " + index);

        // Filling an array
        int[] emptyArray = new int[3];
        Arrays.fill(emptyArray, 100);
        System.out.println("Filled Array: " + Arrays.toString(emptyArray));

        // 6. Array Bounds Exception Example
        try {
            System.out.println(numbers[10]); // This will throw an error
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: Accessed an index outside array range!");
        }
    }
}
