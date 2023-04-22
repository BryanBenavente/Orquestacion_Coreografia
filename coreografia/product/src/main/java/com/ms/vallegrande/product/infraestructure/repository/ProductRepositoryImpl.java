package com.ms.vallegrande.product.infraestructure.repository;

import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.ProductResponse;
import com.ms.vallegrande.product.domain.UpdateProduct;
import com.ms.vallegrande.product.application.repository.ProductRepository;
import com.ms.vallegrande.product.infraestructure.repository.dto.Product;

import com.ms.vallegrande.product.infraestructure.repository.mapper.ProductMapper;
import com.ms.vallegrande.product.infraestructure.repository.mapper.ProductResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;


@Service
public class ProductRepositoryImpl implements ProductRepository {

    private static final ProductMapper mapper = ProductMapper.INSTANCE;
    private static final ProductResponseMapper mapperResponse = ProductResponseMapper.INSTANCE;

    @Autowired
    private ProductMongoRepository mongoOperations;


    @Override
    public Flux<ProductResponse> findAll() {
        return mongoOperations.findAll()
                .map(mapperResponse::fromProductToProductResponse);
    }

    @Override
    public Mono<ProductResponse> findItemById(String id) {
        return mongoOperations.findById(id)
                .map(mapperResponse::fromProductToProductResponse);
    }

    @Override
    public Mono<ProductResponse> create(ProductRequest product) {
        Product product1 = mapper.fromProductRequestToProduct(product);
        product1.setId(UUID.randomUUID().toString());
        product1.setRegistrationDate(new Date().toString());
        product1.setDueDate(new Date().toString());

        return this.mongoOperations.save(product1)
                .map(mapperResponse::fromProductToProductResponse);
    }

    @Override
    public Mono<ProductResponse> update(UpdateProduct updateProduct) {
        return this.findItemById(updateProduct.getId())
                .map(p -> {
                    Product product = mapper.fromUpdateProductToProduct(updateProduct);
                    product.setRegistrationDate(p.getRegistrationDate());
                    product.setDueDate(p.getDueDate());
                    product.setStock(p.getStock() - updateProduct.getCant());

                    this.mongoOperations.save(product).subscribe();
                    return p;
                });
    }

}
