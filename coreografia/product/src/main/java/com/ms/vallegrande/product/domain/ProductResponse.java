package com.ms.vallegrande.product.domain;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private String id;
    private String name;
    private Integer stock;
    private BigDecimal price;
    private String registrationDate;
    private String dueDate;

}
