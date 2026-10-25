package com.vallegrande.order.infrastructure.repository;

import com.vallegrande.order.application.repository.OrderRepository;
import com.vallegrande.order.domain.OrderRequest;
import com.vallegrande.order.domain.OrderResponse;
import com.vallegrande.order.infrastructure.event.RequestMessageProducer;
import com.vallegrande.order.infrastructure.repository.dto.Order;
import com.vallegrande.order.infrastructure.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class OrderRepositoryImpl implements OrderRepository {

    private static final OrderMapper mapper = OrderMapper.INSTANCE;

    @Autowired
    private RequestMessageProducer producer;

    @Autowired
    private OrderMongoRepository mongoRepository;

    @Override
    public Mono<OrderResponse> saveOrder(OrderRequest orderRequest) {
        Order order = mapper.fromOrderRequestToOrder(orderRequest);
        order.setId(UUID.randomUUID().toString());

        return mongoRepository.insert(order)
                .map((Order o ) -> {
                    producer.sendMessage(o.getBook());
                    return OrderResponse.builder()
                            .orderId(o.getId())
                            .status("PROCESO")
                            .build();
                });
    }

}
