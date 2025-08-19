package com.devsenior.tienda_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenior.tienda_mongodb.model.Producto;
import com.devsenior.tienda_mongodb.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repo;

    public List<Producto> findAll() {
        return repo.findAll();
    }

    public Optional<Producto> findById(String id) {
        return repo.findById(id);
    }

    public Producto save(Producto product) {
        return repo.save(product);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
