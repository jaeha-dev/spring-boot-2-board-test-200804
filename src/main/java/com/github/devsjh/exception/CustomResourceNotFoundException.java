package com.github.devsjh.exception;

public class CustomResourceNotFoundException extends RuntimeException {

    public CustomResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CustomResourceNotFoundException(String message) {
        super(message);
    }

    public CustomResourceNotFoundException() {
        super();
    }
}