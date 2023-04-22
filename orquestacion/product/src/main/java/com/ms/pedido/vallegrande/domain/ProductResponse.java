package com.ms.pedido.vallegrande.domain;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class ProductResponse {

    private String id;
    private String name;
    private Integer stock;
    private BigDecimal price;

}
