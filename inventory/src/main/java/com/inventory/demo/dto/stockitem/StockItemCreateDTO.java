package com.inventory.demo.dto.stockitem;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockItemCreateDTO {

    @NotNull(message = "Product ID must not be null.")
    private Long productId;

    @Min(value = 0, message = "Quantity must be greater than or equal to 0.")
    private double quantity;

    @NotBlank(message = "Location must not be blank.")
    private String location;

    @NotNull(message = "Owner ID must not be null.")
    private Long ownerId;
}


