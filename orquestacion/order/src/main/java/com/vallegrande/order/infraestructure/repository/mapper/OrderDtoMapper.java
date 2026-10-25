package com.vallegrande.order.infraestructure.repository.mapper;

import com.vallegrande.order.domain.common.Money;
import com.vallegrande.order.domain.sales.InfoBook;
import com.vallegrande.order.domain.sales.order.Order;
import com.vallegrande.order.domain.sales.order.OrderLine;
import com.vallegrande.order.infraestructure.repository.entity.BookEntity;
import com.vallegrande.order.infraestructure.repository.entity.OrderEntity;
import com.vallegrande.order.infraestructure.repository.entity.OrderLineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface OrderDtoMapper {

    OrderDtoMapper MAPPER = Mappers.getMapper(OrderDtoMapper.class);

    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "orderLines", target = "orderLines", qualifiedByName = "toOrderLines")
    OrderEntity toOrderEntity(Order order);

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "orderLines", target = "orderLines", qualifiedByName = "toOrders")
    Order toOrder(OrderEntity order);

    @Named("toOrderLines")
    default List<OrderLineEntity> toOrderLines(List<OrderLine> orderLines) {
        List<OrderLineEntity> entities = new ArrayList<>();

        if(!CollectionUtils.isEmpty(orderLines))
            orderLines.forEach(orderLine -> {
                OrderLineEntity orderLineEntity = new OrderLineEntity();

                orderLineEntity.setBook(new BookEntity(
                        orderLine.getBook().getBookId(),
                        orderLine.getBook().getTitle(),
                        orderLine.getBook().getPrice().getValue(),
                        orderLine.getBook().getPrice().getCurrency(),
                        orderLine.getAmount()));
                orderLineEntity.setFinalPrice(orderLine.getFinalPrice().getValue());
                orderLineEntity.setCurrency(orderLine.getFinalPrice().getCurrency());

                entities.add(orderLineEntity);
            });

        return entities;
    }

    @Named("toOrders")
    default List<OrderLine> toOrders(List<OrderLineEntity> orderLines) {
        List<OrderLine> entities = new ArrayList<>();

        if(!CollectionUtils.isEmpty(orderLines))
            orderLines.forEach(entity -> {
                OrderLine orderLine = new OrderLine(
                        new InfoBook(
                                entity.getBook().getId(),
                                entity.getBook().getTitle(),
                                new Money(entity.getBook().getPrice()),
                                entity.getBook().getStock()),
                        entity.getAmount(),
                        new Money(entity.getFinalPrice())
                );

                entities.add(orderLine);
            });

        return entities;
    }

}
