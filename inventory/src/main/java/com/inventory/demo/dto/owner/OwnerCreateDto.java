package com.inventory.demo.dto.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerCreateDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Type is required")
    @Size(max = 100, message = "Type cannot exceed 100 characters")
    private String type;

    @Size(max = 255, message = "Contact info cannot exceed 255 characters")
    private String contactInfo;
}

