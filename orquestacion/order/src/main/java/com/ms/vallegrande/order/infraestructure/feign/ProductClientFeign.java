package com.ms.vallegrande.order.infraestructure.feign;

import com.ms.vallegrande.order.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClientFeign {

    @GetMapping(value = "/product/{id}")
    Product findItemById(@PathVariable String id);

}
