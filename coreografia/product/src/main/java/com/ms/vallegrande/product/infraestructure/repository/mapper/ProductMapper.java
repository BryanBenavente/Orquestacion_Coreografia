package com.ms.vallegrande.product.infraestructure.repository.mapper;

import com.ms.vallegrande.product.domain.ProductRequest;
import com.ms.vallegrande.product.domain.UpdateProduct;
import com.ms.vallegrande.product.infraestructure.repository.dto.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductMapper {

    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract Product fromProductRequestToProduct(ProductRequest product);

    public abstract Product fromUpdateProductToProduct(UpdateProduct product);

}
