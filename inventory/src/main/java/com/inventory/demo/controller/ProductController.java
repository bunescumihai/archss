package com.inventory.demo.controller;

import com.inventory.demo.dto.product.ProductCreateDto;
import com.inventory.demo.entity.Product;
import com.inventory.demo.mediator.ServiceMediator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ServiceMediator serviceMediator;

    @GetMapping
    public List<Product> getAll() {
        return serviceMediator.getProductService().findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return serviceMediator.getProductService().findById(id);
    }

    @PostMapping
    public Product create(@Valid @RequestBody ProductCreateDto productCreateDto) {
        return serviceMediator.getProductService().save(productCreateDto);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return serviceMediator.getProductService().update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceMediator.getProductService().delete(id);
    }
}

