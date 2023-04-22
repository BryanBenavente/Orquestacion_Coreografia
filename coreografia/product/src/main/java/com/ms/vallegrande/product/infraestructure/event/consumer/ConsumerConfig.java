package com.ms.vallegrande.product.infraestructure.event.consumer;

import com.ms.vallegrande.product.application.ProductService;
import com.ms.vallegrande.product.application.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class ConsumerConfig {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public RequestMessageConsumer consumerProduct() {
        return new RequestMessageConsumer(productService());
    }

}
