package com.vallegrande.order.infraestructure.rest;

import com.vallegrande.order.application.OrderService;
import com.vallegrande.order.domain.sales.order.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class SalesController {

    private final OrderService orderService;

    public SalesController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{orderId}")
    public void createOrder(@PathVariable Long orderId) {
        orderService.createOrder(orderId);
    }

    @PostMapping("/{orderId}/add")
    public void addBook(
            @PathVariable Long orderId,
            @RequestParam Long clientId,
            @RequestParam String bookId,
            @RequestParam int amount
    ) {
        orderService.addBook(orderId, clientId, bookId, amount);
    }

    @PostMapping("/{orderId}/pay")
    public void payOrder(@PathVariable Long orderId) {
        orderService.payOrder(orderId);
    }

    @GetMapping("/{orderId}/search")
    public Order searchOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

}
