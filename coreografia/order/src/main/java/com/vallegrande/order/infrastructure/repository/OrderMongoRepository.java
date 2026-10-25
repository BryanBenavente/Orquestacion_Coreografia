package com.vallegrande.order.infrastructure.repository;

import com.vallegrande.order.infrastructure.repository.dto.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMongoRepository extends ReactiveMongoRepository<Order, String> {

}
