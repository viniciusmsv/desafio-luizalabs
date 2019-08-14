package com.luizalabs.util;

import com.luizalabs.service.ClientService;

import java.util.logging.Logger;

public class Validator {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());

    public static void validate(boolean condition, RuntimeException message) {
        if (condition) {
            throw message;
        }
    }
}
