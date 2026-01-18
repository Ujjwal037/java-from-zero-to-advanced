package com.ujjwal.java.core.controlflow;

public class ControlFlowDemo {

    public static void main(String[] args) {

        int number = 10;

        // if-else
        if (number > 0) {
            System.out.println("Positive number");
        } else {
            System.out.println("Non-positive number");
        }

        // else-if ladder
        int marks = 75;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 60) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }

        // switch
        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other day");
        }

        // for loop
        for (int i = 1; i <= 3; i++) {
            System.out.println("For loop: " + i);
        }

        // while loop
        int i = 1;
        while (i <= 3) {
            System.out.println("While loop: " + i);
            i++;
        }

        // do-while loop
        int j = 1;
        do {
            System.out.println("Do-while loop: " + j);
            j++;
        } while (j <= 3);

        // break and continue
        for (int k = 1; k <= 5; k++) {
            if (k == 3) {
                continue;
            }
            if (k == 5) {
                break;
            }
            System.out.println("k: " + k);
        }
    }
}

