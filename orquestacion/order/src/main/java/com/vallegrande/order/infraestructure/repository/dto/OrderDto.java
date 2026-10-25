package com.vallegrande.order.infraestructure.repository.dto;

import com.vallegrande.order.domain.sales.InfoClient;
import com.vallegrande.order.domain.sales.order.OrderLine;
import com.vallegrande.order.domain.sales.order.OrderStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long orderId;
    private InfoClient client;
    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderStatusEnum status;

}
