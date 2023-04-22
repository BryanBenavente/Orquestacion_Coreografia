package com.ms.vallegrande.product.application.impl;

import com.ms.vallegrande.product.application.ProductService;
import com.ms.vallegrande.product.application.repository.ProductRepository;
import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.ProductResponse;
import com.ms.vallegrande.product.domain.UpdateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Mono<ProductResponse> getProductId(String id) {
        return repository.findItemById(id);
    }

    @Override
    public Mono<ProductResponse> saveProduct(ProductRequest product) {
        return repository.create(product);
    }

    @Override
    public Flux<ProductResponse> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<ProductResponse> update(UpdateProduct productRequest) {
        return repository.update(productRequest);
    }

}
