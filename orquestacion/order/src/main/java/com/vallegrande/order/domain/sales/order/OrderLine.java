package com.vallegrande.order.domain.sales.order;

import com.vallegrande.order.domain.common.Money;
import com.vallegrande.order.domain.sales.InfoBook;

public class OrderLine {

    private Long id;
    private InfoBook book;
    private int amount;
    private Money finalPrice;

    public OrderLine(InfoBook book, int amount, Money finalPrice) {
        this.book = book;
        this.amount = amount;
        this.finalPrice = finalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InfoBook getBook() {
        return book;
    }

    public void setBook(InfoBook book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Money getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Money finalPrice) {
        this.finalPrice = finalPrice;
    }
}
