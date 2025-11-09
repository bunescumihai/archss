package com.inventory.demo.controller;

import com.inventory.demo.dto.stockitem.StockItemCreateDTO;
import com.inventory.demo.entity.StockItem;
import com.inventory.demo.mediator.ServiceMediator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stock-items")
public class StockItemController {

    @Autowired
    private ServiceMediator serviceMediator;

    @GetMapping
    public List<StockItem> getAll() {
        return serviceMediator.getStockItemService().findAll();
    }

    @GetMapping("/{id}")
    public StockItem getById(@PathVariable Long id) {
        return serviceMediator.getStockItemService().findById(id);
    }

    @PostMapping
    public ResponseEntity<StockItem> createStockItem(@Valid @RequestBody StockItemCreateDTO stockItemCreateDTO) {
        StockItem stockItem = serviceMediator.getStockItemService().save(stockItemCreateDTO);
        return ResponseEntity.status(201).body(stockItem);
    }

    @PutMapping("/{id}")
    public StockItem update(@PathVariable Long id, @RequestBody StockItem stockItem) {
        return serviceMediator.getStockItemService().update(id, stockItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceMediator.getStockItemService().delete(id);
    }
}

