package com.vallegrande.order.domain.sales;

import com.vallegrande.order.domain.common.Money;

public class InfoBook {

    private String bookId;
    private String title;
    private Money price;
    private int stock;

    public InfoBook(String bookId, String title, Money price, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
