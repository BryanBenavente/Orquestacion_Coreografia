package com.ms.vallegrande.order.infrastructure.event;

import com.ms.vallegrande.order.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Sinks;


@Configuration
@Slf4j
public class OrderEvent {

    @Bean
    public Sinks.Many<Message<Product>> orderBuySupplier() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public RequestMessageProducer requestMessageProducer() {
        return new RequestMessageProducer(orderBuySupplier());
    }

}
