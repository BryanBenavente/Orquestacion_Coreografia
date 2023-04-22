package com.ms.vallegrande.order.infraestructure.repository.dto;

import com.ms.vallegrande.order.domain.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private String userId;
    private Product product;
    private String status;
}
