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
@Table(name = "stock_items")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Long productId;

    private double quantity;
    private String location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
    private Long ownerId;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @PreUpdate
    public void onUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }
}

