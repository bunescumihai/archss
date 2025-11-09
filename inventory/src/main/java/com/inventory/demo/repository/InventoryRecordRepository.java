package com.inventory.demo.repository;

import com.inventory.demo.entity.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRecordRepository extends JpaRepository<InventoryRecord, Long> {
}
