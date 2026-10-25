package com.vallegrande.order.domain.sales.order;

public interface OrderRepository {

    void saveOrder(Order order);

    Order searchOrderById(Long orderId);

}
