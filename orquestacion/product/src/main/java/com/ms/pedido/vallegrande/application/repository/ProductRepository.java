package com.ms.pedido.vallegrande.application.repository;

import com.ms.pedido.vallegrande.domain.ProductRequest;
import com.ms.pedido.vallegrande.domain.ProductResponse;
import java.util.List;


public interface ProductRepository {

    List<ProductResponse> findAll();

    ProductResponse findItemById(String id);

    ProductResponse create(ProductRequest productRequest);

    void update(ProductRequest productRequest);

    void delete(String id);

}
