package com.ms.vallegrande.order.infrastructure.repository.mapper;

import com.ms.vallegrande.order.domain.OrderRequest;
import com.ms.vallegrande.order.infrastructure.repository.dto.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class OrderMapper {

    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public abstract Order fromOrderRequestToOrder(OrderRequest orderRequest);

}
