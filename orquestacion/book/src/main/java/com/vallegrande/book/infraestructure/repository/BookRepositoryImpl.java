package com.vallegrande.book.infraestructure.repository;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import com.vallegrande.book.infraestructure.repository.entity.BookEntity;
import com.vallegrande.book.infraestructure.repository.mapper.BookEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private final MongoOperations mongoOperations;

    public BookRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = this.mongoOperations.save(BookEntityMapper.INSTANCE.bookToBookEntity(book));
        return BookEntityMapper.INSTANCE.bookEntityToBook(bookEntity);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        BookEntity book = this.mongoOperations
                .findOne(new Query(Criteria.where("isbn").is(isbn)), BookEntity.class);

        return Objects.isNull(book) ? Optional.empty() :
                Optional.of(BookEntityMapper.INSTANCE.bookEntityToBook(book));
    }

    @Override
    public Optional<Book> findById(String id) {
        BookEntity book = this.mongoOperations
                .findOne(new Query(Criteria.where("id").is(id)), BookEntity.class);

        return Objects.isNull(book) ? Optional.empty() :
                Optional.of(BookEntityMapper.INSTANCE.bookEntityToBook(book));
    }

    @Override
    public List<Book> findAll() {
        List<BookEntity> books = this.mongoOperations.findAll(BookEntity.class);

        return books.stream()
                .map(BookEntityMapper.INSTANCE::bookEntityToBook)
                .toList();
    }

}
