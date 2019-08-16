package com.luizalabs.util;

public class Validator {

    public static void validate(boolean condition, RuntimeException message) {
         if (condition) {
            throw message;
        }
    }
}
