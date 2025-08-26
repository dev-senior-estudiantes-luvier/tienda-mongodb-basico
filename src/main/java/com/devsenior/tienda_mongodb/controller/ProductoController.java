package com.devsenior.tienda_mongodb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.tienda_mongodb.mapper.ProductoMapper;
import com.devsenior.tienda_mongodb.model.Producto;
import com.devsenior.tienda_mongodb.model.dto.ProductoDTO;
import com.devsenior.tienda_mongodb.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService service;

    @GetMapping
    public List<ProductoDTO> getAll() {
        
        return service.findAll().stream().map(ProductoMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Producto create(@RequestBody Producto product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable String id, @RequestBody Producto product) {
        product.setId(id);
        
        Producto original = service.findById(id).orElse(null);
        if (original != null) {
            product.setFechaCreacion(original.getFechaCreacion());
        }
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/falla/runtimeException")
    public void arrojarErrorRuntimeException() {
        throw new RuntimeException("Exception en tiempo de ejecucion");
    }

    @GetMapping("/falla/exception")
    public void arrojarErrorException() throws Exception {
        throw new Exception();
    }
}
