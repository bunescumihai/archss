package com.demand.demo.service.impl.micro;

import com.demand.demo.entity.Product;
import com.demand.demo.service.ProductGetter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestClient;

public class ProductGetterMicroImpl implements ProductGetter {

    private final RestClient inventoryService;

    public ProductGetterMicroImpl(@Qualifier("inventoryService") RestClient inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public Product getProductById(Long id) {
        return inventoryService.get()
                .uri("api/products/{id}", id)
                .retrieve()
                .body(Product.class);
    }
}
