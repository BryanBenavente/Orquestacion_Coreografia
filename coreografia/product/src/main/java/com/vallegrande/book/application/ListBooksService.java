package com.vallegrande.book.application;

import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.application.mapper.BookDtoMapper;
import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ListBooksService {

    private final BookRepository repository;

    public ListBooksService(BookRepository repository) {
        this.repository = repository;
    }

    public Flux<BookDto> listActiveBooks() {
        return repository.findAll()
                .filter(Book::isActive)
                .map(BookDtoMapper.INSTANCE::convertBookEntityToBook);
    }

    public Mono<BookDto> findByIsbn(String isbn) {
        return repository.findItemByIsbn(isbn)
                .map(BookDtoMapper.INSTANCE::convertBookEntityToBook)
                .switchIfEmpty(Mono.fromRunnable(() -> {
                    throw new IllegalArgumentException("No existe un libro con el ISBN " + isbn);
                }));
    }

}
