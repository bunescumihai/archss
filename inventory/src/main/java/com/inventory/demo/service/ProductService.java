package com.inventory.demo.service;

import com.inventory.demo.dto.product.ProductCreateDto;
import com.inventory.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(ProductCreateDto productCreateDto);
    Product update(Long id, Product updated);
    void delete(Long id);
}

