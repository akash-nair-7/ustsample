package com.ust.laptop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptopdto {

    @NotBlank(message = "Laptop name is mandatory")
    private String name;

    @NotBlank(message = "Brand is mandatory")
    private String brand;

    @Min(value = 0, message = "Price should be a non-negative value")
    private double price;

    @NotBlank(message = "Processor type is mandatory")
    private String processor;

    @Min(value = 0, message = "Storage should be a non-negative value")
    private int storage;

    @Size(max = 500, message = "Description should not exceed 500 characters")
    private String description;
}
