package com.vallegrande.order.application;

import com.vallegrande.order.domain.OrderRequest;
import com.vallegrande.order.domain.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<OrderResponse> creteOrder(OrderRequest orderRequest);

}
