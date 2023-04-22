package com.ms.vallegrande.product.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class UpdateProduct {

    private String id;
    private String name;
    private int stock;
    private BigDecimal price;
    private int cant;

}
