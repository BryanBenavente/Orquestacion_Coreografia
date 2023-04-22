package com.ms.vallegrande.order.domain;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class OrderResponse {

    private String orderId;
    private String status;

}
