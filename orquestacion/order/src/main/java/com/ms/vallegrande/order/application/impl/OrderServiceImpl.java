package com.ms.vallegrande.order.application.impl;

import com.ms.vallegrande.order.application.OrderService;
import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import com.ms.vallegrande.order.application.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        return this.orderRepository.save(orderRequest);
    }

    @Override
    public void updateOrder(OrderRequest orderRequest) {
        this.orderRepository.update(orderRequest);
    }

}
