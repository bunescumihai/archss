package com.inventory.demo.repository;

import com.inventory.demo.entity.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
}
