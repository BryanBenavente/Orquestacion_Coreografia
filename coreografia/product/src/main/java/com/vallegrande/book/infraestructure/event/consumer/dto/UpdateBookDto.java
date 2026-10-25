package com.vallegrande.book.infraestructure.event.consumer.dto;

import lombok.Data;

@Data
public class UpdateBookDto {

    private String id;
    private String isbn;
    private int cant;

}
