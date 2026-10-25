package com.vallegrande.book.application;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.infraestructure.event.consumer.dto.UpdateBookDto;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateBookService {

    @Autowired
    private BookRepository repository;

    public Mono<Book> updateStock(UpdateBookDto  updateBookDto) {
        return findBookById(updateBookDto.getIsbn())
                .flatMap(b -> {
                    b.updateStock(updateBookDto.getCant());

                    return repository.update(b);
                });
    }

    private Mono<Book> findBookById(String isbn) {
        return repository.findItemByIsbn(isbn)
                .switchIfEmpty(Mono.fromRunnable(() -> {
                    throw new IllegalArgumentException("No existe un libro con el ISBN " + isbn);
                }));
    }
}