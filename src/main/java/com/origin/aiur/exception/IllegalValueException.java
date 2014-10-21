package com.origin.aiur.exception;

public class IllegalValueException extends Exception {
    private static final long serialVersionUID = 5559387895199249749L;

    public IllegalValueException(String message) {
        super(message);
    }
    
    public IllegalValueException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
