package com.ms.vallegrande.order.infrastructure.rest.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private int errorCode;
    private String message;

}
