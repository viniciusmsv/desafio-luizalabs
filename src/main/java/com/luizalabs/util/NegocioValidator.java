package com.luizalabs.util;

import com.luizalabs.exception.NegocioException;

public class NegocioValidator {

    public static void validate(boolean condition, String message) {
        if (condition) {
            throw new NegocioException(message);
        }
    }
}
