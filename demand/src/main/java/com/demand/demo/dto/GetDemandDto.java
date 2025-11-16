package com.demand.demo.dto;

import com.demand.demo.entity.BuyerProfile;
import com.inventory.demo.entity.Owner;
import com.inventory.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetDemandDto {
    private Owner buyerData;
    private BuyerProfile buyerProfile;

    private Long id;
    private String title;
    private String status;
    private double quantity;
    private LocalDateTime createdAt;
    private LocalDateTime validUntil;

    private Product product;

}
