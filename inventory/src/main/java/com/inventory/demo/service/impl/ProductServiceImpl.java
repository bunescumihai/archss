package com.inventory.demo.service.impl;

import com.inventory.demo.dto.product.ProductCreateDto;
import com.inventory.demo.entity.Product;
import com.inventory.demo.mediator.MapperMediator;
import com.inventory.demo.mediator.RepositoryMediator;
import com.inventory.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RepositoryMediator repositoryMediator;

    @Autowired
    private MapperMediator mapperMediator;

    public List<Product> findAll() {
        return repositoryMediator.getProductRepository().findAll();
    }

    public Product findById(Long id) {
        return repositoryMediator.getProductRepository().findById(id).orElse(null);
    }

    @Transactional
    public Product save(ProductCreateDto productCreateDto) {
        Product product = mapperMediator.getProductMapper().toEntity(productCreateDto);
        return repositoryMediator.getProductRepository().save(product);
    }

    public Product update(Long id, Product updated) {
        updated.setId(id);
        return repositoryMediator.getProductRepository().save(updated);
    }

    public void delete(Long id) {
        repositoryMediator.getProductRepository().deleteById(id);
    }
}
