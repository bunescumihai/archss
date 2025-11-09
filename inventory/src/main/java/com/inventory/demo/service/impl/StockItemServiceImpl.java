package com.inventory.demo.service.impl;

import com.inventory.demo.dto.stockitem.StockItemCreateDTO;
import com.inventory.demo.entity.Owner;
import com.inventory.demo.entity.Product;
import com.inventory.demo.entity.StockItem;
import com.inventory.demo.mediator.MapperMediator;
import com.inventory.demo.mediator.RepositoryMediator;
import com.inventory.demo.service.StockItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemServiceImpl implements StockItemService {

    @Autowired
    private RepositoryMediator repositoryMediator;

    @Autowired
    private MapperMediator mapperMediator;

    public List<StockItem> findAll() {
        return repositoryMediator.getStockItemRepository().findAll();
    }

    public StockItem findById(Long id) {
        return repositoryMediator.getStockItemRepository().findById(id).orElse(null);
    }

    public StockItem save(StockItemCreateDTO stockItemCreateDTO) {

        Product product = repositoryMediator.getProductRepository().findById(stockItemCreateDTO.getProductId()).orElseThrow();
        Owner owner = repositoryMediator.getOwnerRepository().findById(stockItemCreateDTO.getOwnerId()).orElseThrow();

        StockItem stockItem = mapperMediator.getStockItemMapper().toEntity(stockItemCreateDTO);
        stockItem.setProduct(product);
        stockItem.setOwner(owner);
        return repositoryMediator.getStockItemRepository().save(stockItem);
    }

    public StockItem update(Long id, StockItem updated) {
        updated.setId(id);
        return repositoryMediator.getStockItemRepository().save(updated);
    }

    public void delete(Long id) {
        repositoryMediator.getStockItemRepository().deleteById(id);
    }
}

