package com.vallegrande.book.application;

import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.application.mapper.BookDtoMapper;
import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RegisterBookService {

    private final BookRepository repository;

    public RegisterBookService(BookRepository repository) {
        this.repository = repository;
    }

    public Mono<BookDto> registerBook(BookDto book) {
        return repository.findItemByIsbn(book.getIsbn())
                .switchIfEmpty(Mono.defer(() -> {
                    Book newBook = Book.registerNew(book.getTitle(), book.getAuthor(), book.getIsbn(),
                            book.getPrice(), book.getStock(),
                            book.getCategory(), book.getDescription());

                    return repository.create(newBook);
                }))
                .map(BookDtoMapper.INSTANCE::convertBookEntityToBook);
    }

}
