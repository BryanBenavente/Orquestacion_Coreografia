package com.vallegrande.order.application.repository;

import com.vallegrande.order.domain.OrderRequest;
import com.vallegrande.order.domain.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderRepository {

    Mono<OrderResponse> saveOrder(OrderRequest orderRequest);

}
