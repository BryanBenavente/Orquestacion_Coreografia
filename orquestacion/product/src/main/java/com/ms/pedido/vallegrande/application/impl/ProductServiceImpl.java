package com.ms.pedido.vallegrande.application.impl;

import com.ms.pedido.vallegrande.application.ProductService;
import com.ms.pedido.vallegrande.domain.ProductRequest;
import com.ms.pedido.vallegrande.domain.ProductResponse;
import com.ms.pedido.vallegrande.application.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse findItemById(String id) {
        return productRepository.findItemById(id);
    }

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        return productRepository.create(productRequest);
    }

    @Override
    public ResponseEntity<?> update(ProductRequest productRequest) {
        productRepository.update(productRequest);
        return new ResponseEntity<>("ProductRequest update.", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        productRepository.delete(id);
        return new ResponseEntity<>("ProductRequest delete.", HttpStatus.CREATED);
    }

}
