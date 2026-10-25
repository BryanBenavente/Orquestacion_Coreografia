package com.vallegrande.order.application;

import org.springframework.stereotype.Service;
import com.vallegrande.order.domain.sales.order.Order;
import com.vallegrande.order.domain.sales.order.OrderRepository;
import com.vallegrande.order.domain.sales.services.ConsultationBookService;
import com.vallegrande.order.domain.sales.services.ConsultationClientService;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ConsultationClientService consultationClientService;
    private final ConsultationBookService consultationBookService;

    public OrderService(OrderRepository orderRepository,
                        ConsultationClientService consultationClientService,
                        ConsultationBookService consultationBookService) {
        this.orderRepository = orderRepository;
        this.consultationClientService = consultationClientService;
        this.consultationBookService = consultationBookService;
    }

    public void createOrder(Long orderId) {
        Order order = new Order(orderId);

        orderRepository.saveOrder(order);
    }

    public void addBook(Long orderId, Long clientId, String bookId, int amount) {
        Order order = orderRepository.searchOrderById(orderId);
        order.addBook(clientId, bookId, amount, consultationClientService, consultationBookService);

        orderRepository.saveOrder(order);
    }

    public void payOrder(Long orderId) {
        Order order = orderRepository.searchOrderById(orderId);
        order.toPay();

        orderRepository.saveOrder(order);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.searchOrderById(orderId);
    }

}
