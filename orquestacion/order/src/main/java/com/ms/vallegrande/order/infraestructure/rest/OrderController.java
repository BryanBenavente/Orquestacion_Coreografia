package com.ms.vallegrande.order.infraestructure.rest;

import com.ms.vallegrande.order.application.OrderService;
import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    private OrderResponse saveOrder(@RequestBody OrderRequest orderRequest){
        return orderService.saveOrder(orderRequest);
    }

}
