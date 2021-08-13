package com.springboot.server.exception;

public class PasswordNotValidException extends RuntimeException {
    public PasswordNotValidException(String message) {
        super(message);
    }
}
