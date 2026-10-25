package com.vallegrande.order.infrastructure.event;

import com.vallegrande.order.domain.Book;
import com.vallegrande.order.infrastructure.event.dto.UpdateBookDto;
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
public class RequestMessageProducer implements Supplier<Flux<Message<UpdateBookDto>>> {


    private final Sinks.Many<Message<UpdateBookDto>> messageSink;

    public void sendMessage(Book book) {
        UpdateBookDto dto = new UpdateBookDto();
        dto.setId(book.getId());
        dto.setIsbn(book.getIsbn());
        dto.setCant(book.getCant());
        messageSink.emitNext(MessageBuilder.createMessage(dto, new MessageHeaders(new HashMap<>())), Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override
    public Flux<Message<UpdateBookDto>> get() {
        return messageSink.asFlux()
                .doOnNext(m -> log.info("Manually sending message {}", m))
                .doOnError(t -> log.error("Error encountered", t));
    }

}
