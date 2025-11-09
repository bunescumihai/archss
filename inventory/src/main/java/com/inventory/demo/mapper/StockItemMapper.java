package com.inventory.demo.mapper;

import com.inventory.demo.dto.stockitem.StockItemCreateDTO;
import com.inventory.demo.entity.StockItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockItemMapper {

    @Mapping(target = "id", ignore = true)
    StockItem toEntity(StockItemCreateDTO dto);
}
