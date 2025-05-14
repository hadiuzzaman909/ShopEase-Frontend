package com.example.shopease.authentication.exception;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Getter
public class ConstraintValidatorException extends RuntimeException implements Serializable {

    private final transient List<Map.Entry<String, String>> validationErrors;

    public ConstraintValidatorException(String message, List<Map.Entry<String, String>> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }
}