package com.vallegrande.book.application;

import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.application.mapper.BookDtoMapper;
import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookService {

    private final BookRepository repository;

    public RegisterBookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookDto registerBook(BookDto book) {
        repository.findByIsbn(book.getIsbn())
                .ifPresent(existingBook -> {
                    throw new IllegalArgumentException("Existe un libro con el ISBN " + book.getIsbn());
                });

        Book newBook = Book.registerNew(book.getTitle(), book.getAuthor(), book.getIsbn(),
                book.getPrice(), book.getStock(),
                book.getCategory(), book.getDescription());

        return BookDtoMapper.INSTANCE.convertBookEntityToBook(repository.save(newBook));
    }

}
