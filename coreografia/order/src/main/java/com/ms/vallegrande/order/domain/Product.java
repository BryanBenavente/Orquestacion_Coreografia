package com.ms.vallegrande.order.domain;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {

    private String id;
    private String name;
    private int stock;
    private BigDecimal price;
    private int cant;

}
