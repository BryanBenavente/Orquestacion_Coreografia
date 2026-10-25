package com.vallegrande.book.infraestructure.event.consumer;

import com.vallegrande.book.application.UpdateBookService;
import com.vallegrande.book.infraestructure.event.consumer.dto.UpdateBookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Slf4j
@Configuration
public class ConsumerConfig {

    @Bean
    public Consumer<Message<UpdateBookDto>> consumerBook(UpdateBookService updateBookService) {
        return new RequestMessageConsumer(updateBookService);
    }

}
