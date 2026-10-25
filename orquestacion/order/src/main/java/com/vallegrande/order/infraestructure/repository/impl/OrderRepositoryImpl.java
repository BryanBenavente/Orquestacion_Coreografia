package com.vallegrande.order.infraestructure.repository.impl;

import com.vallegrande.order.domain.sales.order.Order;
import com.vallegrande.order.domain.sales.order.OrderRepository;
import com.vallegrande.order.infraestructure.repository.OrderCommandRepository;
import com.vallegrande.order.infraestructure.repository.entity.OrderEntity;
import com.vallegrande.order.infraestructure.repository.mapper.OrderDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderCommandRepository orderCommandRepository;

    public OrderRepositoryImpl(OrderCommandRepository orderCommandRepository) {
        this.orderCommandRepository = orderCommandRepository;
    }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = OrderDtoMapper.MAPPER.toOrderEntity(order);

        if(Objects.nonNull(order.getClient()))
            orderEntity.getClient().setOrder(orderEntity);

        if(!CollectionUtils.isEmpty(order.getOrderLines()) && Objects.nonNull(order.getOrderLines().get(0)))
            orderEntity.getOrderLines().get(0).setOrder(orderEntity);

        orderCommandRepository.save(orderEntity);
    }

    @Override
    public Order searchOrderById(Long orderId) {
        return orderCommandRepository.findById(orderId)
                .map(OrderDtoMapper.MAPPER::toOrder)
                .orElse(null);
    }

}
