package com.vallegrande.book.application.mapper;

import com.vallegrande.book.application.dto.BookDto;
import com.vallegrande.book.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    BookDtoMapper INSTANCE = Mappers.getMapper(BookDtoMapper.class);

    BookDto convertBookEntityToBook(Book book);

}
