package com.vallegrande.book.application;

import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.application.mapper.BookDtoMapper;
import com.vallegrande.book.domain.Book;
import com.vallegrande.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListBooksService {

    private final BookRepository repository;

    public ListBooksService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDto> listActiveBooks() {
        return repository.findAll()
                .stream()
                .filter(Book::isActive)
                .map(BookDtoMapper.INSTANCE::convertBookEntityToBook)
                .collect(Collectors.toList());
    }

    public BookDto findByIsbn(String isbn) {
        return repository.findByIsbn(isbn)
                .map(BookDtoMapper.INSTANCE::convertBookEntityToBook)
                .orElse(null);
    }

}