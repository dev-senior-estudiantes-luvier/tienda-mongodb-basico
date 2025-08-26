package com.devsenior.tienda_mongodb.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoDTO {
    
    private String id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre del producto debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull(message = "El precio del producto es obligatoria")
    @Min(value = 1, message = "El precio del producto debe tener al menos 10 caracteres")
    private Double price;

    private LocalDate fechaCreacion;

}
