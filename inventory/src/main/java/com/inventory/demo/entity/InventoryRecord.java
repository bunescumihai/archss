package com.inventory.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory_records")
public class InventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    private double oldQuantity;

    private double newQuantity;

    private LocalDateTime timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_item_id")
    private StockItem stockItem;

}

