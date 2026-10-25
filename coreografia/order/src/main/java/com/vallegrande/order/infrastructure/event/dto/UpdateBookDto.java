package com.vallegrande.order.infrastructure.event.dto;

import lombok.Data;

@Data
public class UpdateBookDto {

    private String id;
    private String isbn;
    private int cant;

}
