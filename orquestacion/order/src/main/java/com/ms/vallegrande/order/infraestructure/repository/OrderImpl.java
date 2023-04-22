package com.ms.vallegrande.order.infraestructure.repository;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.domain.OrderResponse;
import com.ms.vallegrande.order.application.repository.OrderRepository;
import com.ms.vallegrande.order.domain.Product;
import com.ms.vallegrande.order.infraestructure.feign.ProductClientFeign;
import com.ms.vallegrande.order.infraestructure.repository.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class OrderImpl implements OrderRepository {

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    ProductClientFeign productClientFeign;

    public OrderImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Product product = productClientFeign.findItemById(orderRequest.getProduct().getId());

        if(product != null){
            Order order = new Order();
            order.setId(UUID.randomUUID().toString());
            order.setUserId(orderRequest.getUserId());
            order.setProduct(product);
            order.setStatus(orderRequest.getStatus());

            this.mongoOperations.save(order);

            OrderResponse response = new OrderResponse();
            response.setId(order.getId());
            response.setStatus("ORDEN EN PROCESO");
            return response;
        }
        return null;
    }

    @Override
    public void update(OrderRequest orderRequest) {
        this.mongoOperations.save(orderRequest);
    }

}
