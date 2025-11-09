package com.demand.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "demands")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buyer_profile_id", nullable = false, insertable = false, updatable = false)
    private Long buyerProfileId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "buyer_profile_id")
    private BuyerProfile buyerProfile;

    private String title;
    private String status; // e.g. "OPEN", "CLOSED", "FULFILLED"
    private double quantity;
    private LocalDateTime createdAt;
    private LocalDateTime validUntil;

    @Column(name = "product_id")
    private Long productId;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

