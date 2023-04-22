package com.ms.vallegrande.product.infraestructure.repository;

import com.ms.vallegrande.product.infraestructure.repository.dto.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductMongoRepository extends ReactiveMongoRepository<Product, String> {

    Mono<Product> findByName(String name);

}
