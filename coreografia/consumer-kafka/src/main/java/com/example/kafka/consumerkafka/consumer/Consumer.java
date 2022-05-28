package com.example.kafka.consumerkafka.consumer;

import com.example.kafka.consumerkafka.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "topic-demo", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Product product) {
        log.info("Mensaje recibido: " + product);
    }

}
