package com.demand.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDemandDto {
    private Long ownerId;
    private CreateBuyerProfileDto buyerProfileDto;

    private String title;
    private String status;
    private Double quantity;
    private LocalDateTime validUntil;
    private Long productId;
}
