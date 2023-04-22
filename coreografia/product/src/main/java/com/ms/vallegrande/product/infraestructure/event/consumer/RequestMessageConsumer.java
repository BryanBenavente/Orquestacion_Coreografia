package com.ms.vallegrande.product.infraestructure.event.consumer;

import com.google.gson.Gson;
import com.ms.vallegrande.product.application.ProductService;
import com.ms.vallegrande.product.domain.UpdateProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Slf4j
@RequiredArgsConstructor
public class RequestMessageConsumer implements Consumer<Message<UpdateProduct>> {

    @Autowired
    private final ProductService productService;

    @Override
    public void accept(Message<UpdateProduct> requestMessageMessage) {
        productService.update(requestMessageMessage.getPayload())
                .map(productResponse -> {
                    log.info("UPDATE: '{}'", new Gson().toJson(productResponse));
                    return productResponse;
                }).subscribe();
    }

}
