package com.inventory.demo.service.impl;


import com.inventory.demo.entity.InventoryRecord;
import com.inventory.demo.repository.InventoryRecordRepository;
import com.inventory.demo.service.InventoryRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryRecordServiceImpl implements InventoryRecordService {

    private final InventoryRecordRepository repository;

    public InventoryRecordServiceImpl(InventoryRecordRepository repository) {
        this.repository = repository;
    }

    public List<InventoryRecord> findAll() {
        return repository.findAll();
    }

    public InventoryRecord findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InventoryRecord save(InventoryRecord record) {
        return repository.save(record);
    }

    public InventoryRecord update(Long id, InventoryRecord updated) {
        updated.setId(id);
        return repository.save(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

