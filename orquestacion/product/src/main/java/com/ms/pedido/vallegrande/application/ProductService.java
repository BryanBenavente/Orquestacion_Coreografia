package com.ms.pedido.vallegrande.application;

import com.ms.pedido.vallegrande.domain.ProductRequest;
import com.ms.pedido.vallegrande.domain.ProductResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface ProductService {

    List<ProductResponse> findAll();

    ProductResponse findItemById(String id);

    ProductResponse create(ProductRequest productRequest);

    ResponseEntity<?> update(ProductRequest productRequest);

    ResponseEntity<?> delete(String id);

}
