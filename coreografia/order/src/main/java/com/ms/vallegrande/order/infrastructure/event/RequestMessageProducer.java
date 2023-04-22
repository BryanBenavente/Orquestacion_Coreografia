package com.ms.vallegrande.order.infrastructure.event;

import com.ms.vallegrande.order.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.function.Supplier;


@RequiredArgsConstructor
@Slf4j
public class RequestMessageProducer implements Supplier<Flux<Message<Product>>> {


    private final Sinks.Many<Message<Product>> messageSink;

    public void sendMessage(Product product) {
        messageSink.emitNext(MessageBuilder.createMessage(product, new MessageHeaders(new HashMap<>())), Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override
    public Flux<Message<Product>> get() {
        return messageSink.asFlux()
                .doOnNext(m -> log.info("Manually sending message {}", m))
                .doOnError(t -> log.error("Error encountered", t));
    }

}
