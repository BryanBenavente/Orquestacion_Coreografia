package com.ms.vallegrande.order.infrastructure.rest.config;

public class OrderException extends RuntimeException {

    private final String userId;

    public OrderException(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
