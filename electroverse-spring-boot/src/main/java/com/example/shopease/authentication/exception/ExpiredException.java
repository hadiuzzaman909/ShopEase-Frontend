package com.example.shopease.authentication.exception;

public class ExpiredException extends RuntimeException {

    public ExpiredException(String message) {
        super(message);
    }
}