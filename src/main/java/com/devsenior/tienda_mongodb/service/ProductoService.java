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
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> findById(String id){
        return productoRepository.findById(id);
    }

    public void delete(String id){
        productoRepository.deleteById(id);
    }

    public Producto update(String id, Producto productoActualizado){
        Optional<Producto> productoExistente = productoRepository.findById(id);
        
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setStock(productoActualizado.getStock());
            
            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    
}
