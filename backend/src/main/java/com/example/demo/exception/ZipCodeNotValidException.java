package com.example.demo.exception;

public class ZipCodeNotValidException extends RuntimeException {

    public ZipCodeNotValidException(String message) {
        super(message);
    }

}