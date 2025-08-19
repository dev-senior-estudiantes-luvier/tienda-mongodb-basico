package com.devsenior.tienda_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.tienda_mongodb.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    
}
