package com.ms.pedido.vallegrande.infraestructure.rest;

import com.ms.pedido.vallegrande.application.ProductService;
import com.ms.pedido.vallegrande.domain.ProductRequest;
import com.ms.pedido.vallegrande.domain.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/listProducts")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findItemById(@PathVariable String id){
        return productService.findItemById(id);
    }

    @PostMapping
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest){
        return productService.create(productRequest);
    }

    @PutMapping
    public ResponseEntity<?>  update(@RequestBody ProductRequest productRequest) {
        return productService.update(productRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return productService.delete(id);
    }

}
