package com.ms.vallegrande.order.application;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<OrderResponse> creteOrder(OrderRequest orderRequest);

}
