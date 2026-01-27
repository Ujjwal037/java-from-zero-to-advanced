package com.ujjwal.java.exception.multiplecatch;

public class MultipleCatchDemo {

    public static void main(String[] args) {

        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException

            int[] arr = new int[3];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException

        } catch (NullPointerException e) {
            System.out.println("Null pointer exception occurred");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (Exception e) {
            System.out.println("Generic exception caught");
        } finally {
            System.out.println("Finally block always executes");
        }
    }
}

