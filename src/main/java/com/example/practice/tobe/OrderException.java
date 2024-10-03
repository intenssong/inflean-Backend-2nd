package com.example.practice.tobe;

public class OrderException extends RuntimeException {
    String message;

    public OrderException(String message) {
        super(message);
    }

}
