package com.ujjwal.java.java8.StreamPracticeQuestions;
import java.util.*;
import java.util.stream.*;


public class StreamEasyLevelQuestions {
    public static void main(String[] args){

        //Filter Even Numbers
        List <Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> EvenNumbers = list.stream()
                                        .filter(e -> e % 2 == 0)
                                        .toList(); // Print in the list
        System.out.println("Even numbers list :"+EvenNumbers);
            list.stream()
                .filter(e -> e %2==0)
                .forEach(System.out::println); // Directly print it


        //Convert List of Strings to Uppercase
        List <String> list2 = Arrays.asList("apple","orange","banana","grapes");
        List<String> UpperCaseString = list2.stream().map(String::toUpperCase).toList();
        System.out.println("UpperCaseString list :"+UpperCaseString);
        //When a String is given
        String str = "jai shree ram";
        String UpperCaseString2 = str.chars().mapToObj(c -> String.valueOf((char) Character.toUpperCase(c))).collect(Collectors.joining());
        System.out.println("UpperCaseString2 String :"+UpperCaseString2);

    }
}
