package com.ms.pedido.vallegrande.domain;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class ProductRequest {

    private String name;
    private Integer stock;
    private BigDecimal price;

}
