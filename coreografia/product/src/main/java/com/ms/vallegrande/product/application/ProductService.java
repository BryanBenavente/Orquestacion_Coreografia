package com.ms.vallegrande.product.application;

import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.ProductResponse;
import com.ms.vallegrande.product.domain.UpdateProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<ProductResponse> getProductId(String id);

    Mono<ProductResponse> saveProduct(ProductRequest product);

    Flux<ProductResponse> getAll();

    Mono<ProductResponse> update(UpdateProduct productRequest);

}
