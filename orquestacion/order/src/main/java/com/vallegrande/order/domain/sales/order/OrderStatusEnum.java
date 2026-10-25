package com.vallegrande.order.domain.sales.order;

public enum OrderStatusEnum {

    PENDING("OE1", "PENDING"),
    PAID("OE2", "PAID");

    private String code;
    private String value;

    OrderStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

}
