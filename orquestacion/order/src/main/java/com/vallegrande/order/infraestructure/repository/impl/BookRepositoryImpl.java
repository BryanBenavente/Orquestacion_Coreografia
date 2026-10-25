package com.vallegrande.order.infraestructure.repository.impl;

import com.vallegrande.order.domain.common.Money;
import com.vallegrande.order.domain.sales.InfoBook;
import com.vallegrande.order.domain.sales.services.ConsultationBookService;
import com.vallegrande.order.infraestructure.feign.BookClientFeign;
import com.vallegrande.order.infraestructure.feign.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookRepositoryImpl implements ConsultationBookService {

    private final BookClientFeign clientFeign;

    public BookRepositoryImpl(BookClientFeign clientFeign) {
        this.clientFeign = clientFeign;
    }

    @Override
    public InfoBook searchBookById(String isbn) {
        BookDto bookDto = clientFeign.findItemByIsbn(isbn);
        InfoBook book = null;

        if(Objects.nonNull(bookDto))
            book = new InfoBook(
                    bookDto.getId(),
                    bookDto.getTitle(),
                    new Money(bookDto.getPrice().doubleValue()),
                    bookDto.getStock()
            );

        return book;
    }

}
