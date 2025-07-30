package com.devsenior.tienda_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "productos")
@Data
public class Producto {
    @Id
    private String id;
    private String nombre;
    private Double precio;
    private Long stock;
    private String descripcion;
}
