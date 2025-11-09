package com.inventory.demo.mediator;

import com.inventory.demo.mapper.OwnerMapper;
import com.inventory.demo.mapper.ProductMapper;
import com.inventory.demo.mapper.StockItemMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MapperMediator {

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StockItemMapper stockItemMapper;
}
