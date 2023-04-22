package com.ms.pedido.vallegrande.infraestructure.repository;

import com.ms.pedido.vallegrande.domain.ProductRequest;
import com.ms.pedido.vallegrande.domain.ProductResponse;
import com.ms.pedido.vallegrande.application.repository.ProductRepository;
import com.ms.pedido.vallegrande.infraestructure.repository.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
public class ProductImpl implements ProductRepository {

    @Autowired
    private final MongoOperations mongoOperations;

    protected ProductImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = this.mongoOperations.findAll(Product.class);
        List<ProductResponse> productResponses = new ArrayList<>();

        products.forEach(p -> {
            ProductResponse response = getProductResponse(p);
            productResponses.add(response);
        });

        return productResponses;
    }

    @Override
    public ProductResponse findItemById(String id) {
        Product product = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Product.class);

        ProductResponse response = getProductResponse(product);

        return response;
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());

        Product p = this.mongoOperations.save(product);

        ProductResponse response = getProductResponse(p);

        return response;
    }

    @Override
    public void update(ProductRequest productRequest) {
        Product product = this.mongoOperations.findOne(new Query(Criteria.where("name").is(productRequest.getName())), Product.class);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());

        this.mongoOperations.save(product);
    }

    @Override
    public void delete(String id) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Product.class);
    }

    private ProductResponse getProductResponse(Product p) {
        ProductResponse response = new ProductResponse();
        response.setId(p.getId());
        response.setName(p.getName());
        response.setStock(p.getStock());
        response.setPrice(p.getPrice());
        return response;
    }

}
