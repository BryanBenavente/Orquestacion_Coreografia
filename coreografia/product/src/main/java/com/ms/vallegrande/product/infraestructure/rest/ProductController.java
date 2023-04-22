package com.ms.vallegrande.product.infraestructure.rest;

import com.ms.vallegrande.product.application.ProductService;
import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/listProducts")
    public Flux<ProductResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductResponse> getProductId(@PathVariable String id){
        return productService.getProductId(id);
    }

    @PostMapping
    public Mono<ProductResponse> saveProduct(@RequestBody ProductRequest product){
        return productService.saveProduct(product);
    }

}
