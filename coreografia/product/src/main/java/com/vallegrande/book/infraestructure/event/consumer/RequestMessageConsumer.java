package com.vallegrande.book.infraestructure.event.consumer;

import com.vallegrande.book.application.UpdateBookService;
import com.vallegrande.book.infraestructure.event.consumer.dto.UpdateBookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Slf4j
@RequiredArgsConstructor
public class RequestMessageConsumer implements Consumer<Message<UpdateBookDto>> {

    private final UpdateBookService updateBookService;

    @Override
    public void accept(Message<UpdateBookDto> msg) {
        updateBookService.updateStock(msg.getPayload())
                .subscribe(b -> log.info("Book updated successfully: {}", b.getId()));
    }

}
