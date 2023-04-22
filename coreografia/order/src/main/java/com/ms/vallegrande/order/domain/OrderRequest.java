package com.ms.vallegrande.order.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

    private String userId;
    private Product product;
    private String status;

}
