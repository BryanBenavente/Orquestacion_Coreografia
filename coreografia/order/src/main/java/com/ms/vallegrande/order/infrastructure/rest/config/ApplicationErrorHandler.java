package com.ms.vallegrande.order.infrastructure.rest.config;

import com.ms.vallegrande.order.infrastructure.rest.config.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApplicationErrorHandler {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(OrderException e){
        var errorResponse = this.buildErrorResponse(400, String.format("La cantidad solicitada es mayor al stock"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    private ErrorResponse buildErrorResponse(int code, String message){
        return new ErrorResponse(code, message);
    }

}
