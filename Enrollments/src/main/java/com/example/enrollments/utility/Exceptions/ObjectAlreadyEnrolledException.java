package com.example.enrollments.utility.Exceptions;

public class ObjectAlreadyEnrolledException extends RuntimeException {
    public ObjectAlreadyEnrolledException(String message) {
        super(message);
    }
}
