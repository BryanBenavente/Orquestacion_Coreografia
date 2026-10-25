package com.vallegrande.order.infraestructure.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    private String id;

    private String title;

    private double price;

    private String currency;

    private int stock;

    @OneToOne(mappedBy = "book")
    private OrderLineEntity orderLine;

    public BookEntity() {
    }

    public BookEntity(String id, String title, double price, String currency, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public OrderLineEntity getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLineEntity orderLine) {
        this.orderLine = orderLine;
    }
}
