package com.inventory.demo.mapper;

import com.inventory.demo.dto.owner.OwnerCreateDto;
import com.inventory.demo.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(target = "id", ignore = true)
    Owner toEntity(OwnerCreateDto dto);
}
