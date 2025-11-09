package com.inventory.demo.service;

import com.inventory.demo.dto.stockitem.StockItemCreateDTO;
import com.inventory.demo.entity.StockItem;

import java.util.List;

public interface StockItemService {
    List<StockItem> findAll();
    StockItem findById(Long id);
    StockItem save(StockItemCreateDTO stockItemCreateDTO);
    StockItem update(Long id, StockItem updated);
    void delete(Long id);
}

