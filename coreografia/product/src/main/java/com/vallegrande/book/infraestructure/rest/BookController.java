package com.vallegrande.book.infraestructure.rest;

import com.vallegrande.book.application.ListBooksService;
import com.vallegrande.book.application.RegisterBookService;
import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.infraestructure.rest.dto.BookWebDto;
import com.vallegrande.book.infraestructure.rest.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private RegisterBookService registerBookService;

    @Autowired
    private ListBooksService listBooksService;

    @GetMapping("/listProducts")
    public Flux<BookWebDto> getAll(){
        return listBooksService.listActiveBooks()
                .map(BookMapper.INSTANCE::bookDtoToBookWebDto);
    }

    @GetMapping("/{isbn}")
    public Mono<BookWebDto> getBookIsbn(@PathVariable String isbn){
        return listBooksService.findByIsbn(isbn)
                .map(BookMapper.INSTANCE::bookDtoToBookWebDto);
    }

    @PostMapping
    public Mono<BookWebDto> saveProduct(@RequestBody BookWebDto bookWebDto){
        BookDto bookDto = BookMapper.INSTANCE.bookWebDtoToBookDto(bookWebDto);

        return registerBookService.registerBook(bookDto)
                .map(BookMapper.INSTANCE::bookDtoToBookWebDto);
    }

}
