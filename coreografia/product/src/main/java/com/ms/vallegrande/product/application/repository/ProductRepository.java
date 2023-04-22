package com.ms.vallegrande.product.application.repository;

import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.ProductResponse;
import com.ms.vallegrande.product.domain.UpdateProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProductRepository {

    Flux<ProductResponse> findAll();

    Mono<ProductResponse> findItemById(String id);

    Mono<ProductResponse> create(ProductRequest product);

    Mono<ProductResponse> update(UpdateProduct product);

}
