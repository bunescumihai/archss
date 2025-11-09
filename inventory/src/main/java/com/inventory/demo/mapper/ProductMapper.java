package com.inventory.demo.mapper;

import com.inventory.demo.dto.product.ProductCreateDto;
import com.inventory.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductCreateDto dto);
}
