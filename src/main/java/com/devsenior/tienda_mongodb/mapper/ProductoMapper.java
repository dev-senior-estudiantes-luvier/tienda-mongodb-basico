package com.devsenior.tienda_mongodb.mapper;

import com.devsenior.tienda_mongodb.model.Producto;
import com.devsenior.tienda_mongodb.model.dto.ProductoDTO;

public class ProductoMapper {
    public static ProductoDTO toDTO(Producto entity) {
        if (entity == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setFechaCreacion(entity.getFechaCreacion());
        
        return dto;
    }

    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setName(dto.getName());
        producto.setPrice(dto.getPrice());
        producto.setFechaCreacion(dto.getFechaCreacion());
        return producto;
    }
}
