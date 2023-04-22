package com.ms.vallegrande.product.infraestructure.repository.mapper;

import com.ms.vallegrande.product.domain.ProductResponse;
import com.ms.vallegrande.product.infraestructure.repository.dto.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductResponseMapper {

    public static final ProductResponseMapper INSTANCE = Mappers.getMapper(ProductResponseMapper.class);

    public abstract ProductResponse fromProductToProductResponse(Product product);

}
