package com.ms.vallegrande.order.domain;

import lombok.Data;

@Data
public class OrderRequest {

    private String userId;
    private Product product;
    private String status;

}
