package com.vallegrande.book.domain.repository;

import com.vallegrande.book.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Flux<Book> findAll();

    Mono<Book> findItemByIsbn(String isbn);

    Mono<Book> create(Book book);

    Mono<Book> update(Book book);

}