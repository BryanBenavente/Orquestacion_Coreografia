package com.ms.vallegrande.order.application.repository;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderRepository {

    Mono<OrderResponse> saveOrder(OrderRequest orderRequest);

}
