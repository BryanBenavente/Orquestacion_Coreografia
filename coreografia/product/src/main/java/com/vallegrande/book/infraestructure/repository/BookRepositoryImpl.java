package com.vallegrande.book.infraestructure.repository;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;

import com.vallegrande.book.infraestructure.repository.entity.BookEntity;
import com.vallegrande.book.infraestructure.repository.mapper.BookEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
public class BookRepositoryImpl implements BookRepository {

    private static final BookEntityMapper mapper = BookEntityMapper.INSTANCE;

    @Autowired
    private BookMongoRepository mongoOperations;


    @Override
    public Flux<Book> findAll() {
        return mongoOperations.findAll()
                .map(mapper::bookEntityToBook);
    }

    @Override
    public Mono<Book> findItemByIsbn(String isbn) {
        return mongoOperations.findByIsbn(isbn)
                .map(mapper::bookEntityToBook);
    }

    @Override
    public Mono<Book> create(Book book) {
        BookEntity bookEntity1 = mapper.bookToBookEntity(book);
        bookEntity1.setId(UUID.randomUUID().toString());

        return this.mongoOperations.save(bookEntity1)
                .map(mapper::bookEntityToBook);
    }

    @Override
    public Mono<Book> update(Book book) {
        BookEntity bookEntity1 = mapper.bookToBookEntity(book);

        return this.mongoOperations.save(bookEntity1)
                .map(mapper::bookEntityToBook);
    }

}
