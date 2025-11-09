package com.inventory.demo.controller;

import com.inventory.demo.entity.InventoryRecord;
import com.inventory.demo.service.InventoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory-records")
public class InventoryRecordController {

    @Autowired
    private final InventoryRecordService service;

    public InventoryRecordController(InventoryRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryRecord> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InventoryRecord getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public InventoryRecord create(@RequestBody InventoryRecord record) {
        return service.save(record);
    }

    @PutMapping("/{id}")
    public InventoryRecord update(@PathVariable Long id, @RequestBody InventoryRecord record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
