package com.ms.vallegrande.order.infrastructure.rest;

import com.ms.vallegrande.order.application.OrderService;
import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import com.ms.vallegrande.order.infrastructure.rest.config.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    private Mono<OrderResponse> saveOrder(@RequestBody OrderRequest order){
        return orderService.creteOrder(order)
                .switchIfEmpty(Mono.error(new OrderException(order.getUserId())));
    }

}
