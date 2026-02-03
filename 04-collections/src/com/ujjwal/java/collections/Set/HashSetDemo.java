package com.ujjwal.java.collections.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        Set<String> skills = new HashSet<>();

        skills.add("Java");
        skills.add("Spring");
        skills.add("Java"); // duplicate

        System.out.println(skills);
    }
    class Employee {
        int id;

        Employee(int id) {
            this.id = id;
        }

        public int hashCode() {
            return id;
        }

        public boolean equals(Object o) {
            Employee e = (Employee) o;
            return this.id == e.id;
        }
    }

}

