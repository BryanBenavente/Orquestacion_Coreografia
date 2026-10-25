package com.vallegrande.order.application.impl;

import com.vallegrande.order.application.OrderService;
import com.vallegrande.order.application.repository.OrderRepository;
import com.vallegrande.order.domain.OrderRequest;
import com.vallegrande.order.domain.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Mono<OrderResponse> creteOrder(OrderRequest orderRequest) {
        int cant = orderRequest.getBook().getCant();

        if(cant < orderRequest.getBook().getStock()) {
            return repository.saveOrder(orderRequest);
        }

        return Mono.empty();
    }

}
