package com.vallegrande.book.application;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService {

    private final BookRepository repository;

    public DeleteBookService(BookRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.deactivate();
        repository.save(book);
    }
}
