package com.vallegrande.order.infrastructure.event;

import com.vallegrande.order.infrastructure.event.dto.UpdateBookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Sinks;


@Configuration
@Slf4j
public class OrderEvent {

    @Bean
    public Sinks.Many<Message<UpdateBookDto>> orderBuySupplier() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public RequestMessageProducer requestMessageProducer() {
        return new RequestMessageProducer(orderBuySupplier());
    }

}
