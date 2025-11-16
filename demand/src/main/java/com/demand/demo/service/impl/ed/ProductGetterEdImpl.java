package com.demand.demo.service.impl.ed;

import com.demand.demo.entity.Product;
import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.ProductGetter;

public class ProductGetterEdImpl implements ProductGetter {

    private final RepositoryMediator repositoryMediator;

    public ProductGetterEdImpl(RepositoryMediator repositoryMediator) {
        this.repositoryMediator = repositoryMediator;
    }

    @Override
    public Product getProductById(Long id) {
        return repositoryMediator.getProductRepository().findById(id).orElse(null);
    }
}
