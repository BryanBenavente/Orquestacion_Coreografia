package com.vallegrande.order.domain.sales.order;

import com.vallegrande.order.domain.common.Money;
import com.vallegrande.order.domain.sales.InfoBook;
import com.vallegrande.order.domain.sales.InfoClient;
import com.vallegrande.order.domain.sales.services.ConsultationBookService;
import com.vallegrande.order.domain.sales.services.ConsultationClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long orderId; //B00001
    private InfoClient client;
    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderStatusEnum status = OrderStatusEnum.PENDING;

    public Order(Long orderId) {
        this.orderId = orderId;
    }

    public void addBook(Long clientId, String bookId, int amount,
                        ConsultationClientService consultationClientService,
                        ConsultationBookService consultationBookService) {
        InfoClient infoClient = consultationClientService.searchClientById(clientId);
        InfoBook book = consultationBookService.searchBookById(bookId);

        if(Objects.isNull(infoClient))
            throw new IllegalArgumentException("El cliente no se encuentra registrado");

        if(Objects.isNull(book))
            throw new IllegalArgumentException("El libro solicitado no existe");

        if (book.getStock() < amount)
            throw new IllegalArgumentException("Stock insuficiente");

        Money finalPrice = DiscountService.applyDiscount(book.getPrice(), amount);

        client = new InfoClient(infoClient.getId(), infoClient.getName());
        orderLines.add(new OrderLine(book, amount, finalPrice));
    }

    public void toPay() {
        if (!status.equals(OrderStatusEnum.PENDING))
            throw new IllegalStateException("El pedido ya fue procesado o pagado");


        if (orderLines.isEmpty())
            throw new IllegalStateException("No se puede pagar un pedido vacío");

        status = OrderStatusEnum.PAID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public InfoClient getClient() {
        return client;
    }

    public void setClient(InfoClient client) {
        this.client = client;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
