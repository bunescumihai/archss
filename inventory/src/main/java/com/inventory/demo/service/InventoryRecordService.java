package com.inventory.demo.service;

import com.inventory.demo.entity.InventoryRecord;

import java.util.List;

public interface InventoryRecordService {
    List<InventoryRecord> findAll();
    InventoryRecord findById(Long id);
    InventoryRecord save(InventoryRecord record);
    InventoryRecord update(Long id, InventoryRecord updated);
    void delete(Long id);
}
