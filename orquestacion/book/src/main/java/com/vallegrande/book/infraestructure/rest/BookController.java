package com.vallegrande.book.infraestructure.rest;

import com.vallegrande.book.application.DeleteBookService;
import com.vallegrande.book.application.ListBooksService;
import com.vallegrande.book.application.RegisterBookService;
import com.vallegrande.book.application.UpdateBookService;
import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.infraestructure.rest.dto.BookWebDto;
import com.vallegrande.book.infraestructure.rest.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private RegisterBookService registerBookService;

    @Autowired
    private UpdateBookService updateBookService;

    @Autowired
    private DeleteBookService deleteBookService;

    @Autowired
    private ListBooksService listBooksService;


    @GetMapping("/listProducts")
    public List<BookWebDto> findAll(){
        return listBooksService.listActiveBooks()
                .stream().map(BookMapper.INSTANCE::bookDtoToBookWebDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookWebDto saveProduct(@RequestBody BookWebDto bookWebDto){
        BookDto bookDto = BookMapper.INSTANCE.bookWebDtoToBookDto(bookWebDto);

        return BookMapper.INSTANCE.bookDtoToBookWebDto(registerBookService.registerBook(bookDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam String id,
                                     @RequestParam String newDescription) {
        updateBookService.updateDescription(id, newDescription);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        deleteBookService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{isbn}")
    public BookWebDto findByIsbn(@PathVariable String isbn){
        BookDto bookDto = listBooksService.findByIsbn(isbn);

        return BookMapper.INSTANCE.bookDtoToBookWebDto(bookDto);
    }

}
