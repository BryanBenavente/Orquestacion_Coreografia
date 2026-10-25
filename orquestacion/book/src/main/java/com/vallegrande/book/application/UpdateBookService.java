package com.vallegrande.book.application;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UpdateBookService {

    private final BookRepository repository;

    public UpdateBookService(BookRepository repository) {
        this.repository = repository;
    }

    public void updatePrice(String id, BigDecimal newPrice) {
        Book book = findBookById(id);
        book.updatePrice(newPrice);
        repository.save(book);
    }

    public void updateStock(String id, int newStock) {
        Book book = findBookById(id);
        book.updateStock(newStock);
        repository.save(book);
    }

    public void updateDescription(String id, String newDescription) {
        Book book = findBookById(id);
        book.updateDescription(newDescription);

        repository.save(book);
    }

    private Book findBookById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }
}