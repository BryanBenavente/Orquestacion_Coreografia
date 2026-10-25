package com.vallegrande.book.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Book {

    private String id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private int stock;
    private String category;
    private String description;
    private boolean active;

    private Book(String title, String author, String isbn, BigDecimal price, int stock,
                 String category, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
        this.active = stock > 0;
    }

    public static Book registerNew(String title, String author, String isbn, BigDecimal price,
                                   int stock, String category, String description) {
        validateRequiredFields(title, author, isbn, price);
        validatePrice(price);
        validateStock(stock);

        Book book = new Book(title, author, isbn, price, stock, category, description);
        book.setId(UUID.randomUUID().toString());
        return book;
    }

    // --- Business Rules ---
    private static void validateRequiredFields(String title, String author, String isbn, BigDecimal price) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title is required");
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("Author is required");
        if (isbn == null || isbn.isBlank())
            throw new IllegalArgumentException("ISBN is required");
        if (price == null)
            throw new IllegalArgumentException("Price is required");
    }

    private static void validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price must be greater than zero");
    }

    private static void validateStock(int stock) {
        if (stock < 0)
            throw new IllegalArgumentException("Stock cannot be negative");
    }

    // --- Comportamientos de dominio ---
    public void updatePrice(BigDecimal newPrice) {
        validatePrice(newPrice);
        this.price = newPrice;
    }

    public void updateStock(int newStock) {
        validateStock(newStock);
        this.stock = stock - newStock;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
