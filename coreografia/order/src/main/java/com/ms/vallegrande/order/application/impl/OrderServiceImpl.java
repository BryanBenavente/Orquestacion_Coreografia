package com.ms.vallegrande.order.application.impl;

import com.ms.vallegrande.order.application.OrderService;
import com.ms.vallegrande.order.application.repository.OrderRepository;
import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Mono<OrderResponse> creteOrder(OrderRequest orderRequest) {
        int cant = orderRequest.getProduct().getCant();

        if(cant < orderRequest.getProduct().getStock()) {
            return repository.saveOrder(orderRequest);
        }

        return Mono.empty();
    }

}
