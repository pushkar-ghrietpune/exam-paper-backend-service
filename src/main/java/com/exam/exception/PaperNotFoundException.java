package com.exam.exception;

public class PaperNotFoundException extends RuntimeException {

    public PaperNotFoundException(String message) {
        super(message);
    }

}