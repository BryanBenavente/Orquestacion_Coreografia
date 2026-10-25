package com.vallegrande.order.domain.common;

public class Money {

    private double value;
    private String currency = "PEN";

    public Money(double value) {
        if (value < 0)
            throw new IllegalArgumentException("El dinero no puede ser negativo");

        this.value = value;
    }

    public double value() {
        return value;
    }

    public Money multiply(double percentage) {
        return new Money(value * percentage);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
