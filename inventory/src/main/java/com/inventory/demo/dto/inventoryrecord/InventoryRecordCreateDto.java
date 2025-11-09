package com.inventory.demo.dto.inventoryrecord;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InventoryRecordCreateDto {

    @NotNull(message = "Stock item ID is required")
    private Long stockItemId;

    @NotNull(message = "Quantity change is required")
    private Double quantityChange;

    @Min(value = 0, message = "Resulting quantity cannot be negative")
    private Double resultingQuantity;
}

