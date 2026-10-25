package com.vallegrande.book.infraestructure.repository;

import com.vallegrande.book.infraestructure.repository.entity.BookEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookMongoRepository extends ReactiveMongoRepository<BookEntity, String> {

    Mono<BookEntity> findByIsbn(String isbn);

}
