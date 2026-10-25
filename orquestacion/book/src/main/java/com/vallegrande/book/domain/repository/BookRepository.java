package com.vallegrande.book.domain.repository;

import com.vallegrande.book.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findById(String id);
    List<Book> findAll();

}
