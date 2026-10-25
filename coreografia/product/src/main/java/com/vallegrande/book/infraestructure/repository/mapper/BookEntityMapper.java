package com.vallegrande.book.infraestructure.repository.mapper;

import com.vallegrande.book.domain.Book;
import com.vallegrande.book.infraestructure.repository.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {

    BookEntityMapper INSTANCE = Mappers.getMapper(BookEntityMapper.class);

    BookEntity bookToBookEntity(Book book);

    Book bookEntityToBook(BookEntity bookEntity);


    @ObjectFactory
    default Book createBook(BookEntity dto) {
        return Book.registerNew(
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getPrice(),
                dto.getStock(),
                dto.getCategory(),
                dto.getDescription()
        );
    }

}
