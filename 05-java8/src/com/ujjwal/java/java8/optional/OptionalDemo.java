package com.ujjwal.java.java8.optional;

import java.util.*;

public class OptionalDemo {

    public static void main(String[] args) {

        /* =========================================
           1. Creating Optional
           ========================================= */

        Optional<String> optionalValue = Optional.of("Java");

        Optional<String> emptyOptional = Optional.empty();

        Optional<String> nullableOptional = Optional.ofNullable(null);

        System.out.println("Optional.of(): " + optionalValue);
        System.out.println("Optional.empty(): " + emptyOptional);
        System.out.println("Optional.ofNullable(): " + nullableOptional);


        /* =========================================
           2. isPresent() & get() (NOT recommended)
           ========================================= */

        optionalValue.ifPresent(s -> System.out.println("\nValue using get(): " + s));


        /* =========================================
           3. orElse()
           ========================================= */

        String valueOrDefault = nullableOptional.orElse("Default Value");
        System.out.println("\norElse(): " + valueOrDefault);


        /* =========================================
           4. orElseGet()
           ========================================= */

        String valueOrSupplier = nullableOptional.orElseGet(() -> "Supplier Value");
        System.out.println("orElseGet(): " + valueOrSupplier);


        /* =========================================
           5. orElseThrow()
           ========================================= */

        try {
            nullableOptional.orElseThrow(() ->
                    new RuntimeException("Value not present"));
        } catch (Exception e) {
            System.out.println("\norElseThrow(): " + e.getMessage());
        }


        /* =========================================
           6. ifPresent()
           ========================================= */

        optionalValue.ifPresent(val ->
                System.out.println("\nifPresent(): " + val)
        );


        /* =========================================
           7. map()
           ========================================= */

        Optional<Integer> length = optionalValue.map(String::length);
        System.out.println("\nmap(): String length = " + length.orElse(0));


        /* =========================================
           8. flatMap()
           ========================================= */

        Optional<Optional<String>> nestedOptional =
                Optional.of(Optional.of("Nested"));

        Optional<String> flatOptional =
                nestedOptional.flatMap(opt -> opt);

        System.out.println("flatMap(): " + flatOptional.orElse("Empty"));


        /* =========================================
           9. Real-World Example
           ========================================= */

        User user = new User("Ujjwal", null);

        String city = Optional.ofNullable(user.getAddress())
                .map(Address::getCity)
                .orElse("City Not Available");

        System.out.println("\nReal-world example city: " + city);
    }
}

/* =========================================
   Supporting Classes
   ========================================= */

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

