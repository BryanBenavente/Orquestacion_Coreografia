package com.ms.vallegrande.order.application;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import org.springframework.stereotype.Service;


@Service
public interface OrderService {

    OrderResponse saveOrder(OrderRequest orderRequest);

    void updateOrder(OrderRequest orderRequest);
}
