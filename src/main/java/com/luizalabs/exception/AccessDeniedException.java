package com.luizalabs.exception;

import java.io.Serializable;

public class AccessDeniedException extends RuntimeException implements Serializable {
    public AccessDeniedException(String message) {
        super(message);
    }
}
