package com.exam.exception;

public class ClasNotFoundException extends RuntimeException {

    public ClasNotFoundException(String message) {
        super(message);
    }
}