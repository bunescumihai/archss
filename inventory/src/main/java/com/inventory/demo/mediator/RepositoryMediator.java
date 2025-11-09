package com.inventory.demo.mediator;

import com.inventory.demo.repository.OwnerRepository;
import com.inventory.demo.repository.ProductRepository;
import com.inventory.demo.repository.StockItemRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RepositoryMediator {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockItemRepository stockItemRepository;
}
