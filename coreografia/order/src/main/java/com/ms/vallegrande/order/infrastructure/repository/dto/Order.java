package com.ms.vallegrande.order.infrastructure.repository.dto;

import com.ms.vallegrande.order.domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "order")
@Getter
@Setter
public class Order {

    @Id
    private String id;
    private String userId;
    private Product product;
    private String status;

}
