package com.ms.vallegrande.order.application.repository;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;


public interface OrderRepository {

    OrderResponse save(OrderRequest orderRequest);

    void update(OrderRequest orderRequest);

}
