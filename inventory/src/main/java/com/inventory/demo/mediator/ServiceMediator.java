package com.inventory.demo.mediator;

import com.inventory.demo.service.OwnerService;
import com.inventory.demo.service.ProductService;
import com.inventory.demo.service.StockItemService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ServiceMediator {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StockItemService stockItemService;

}
