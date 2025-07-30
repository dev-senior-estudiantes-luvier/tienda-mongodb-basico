package com.devsenior.tienda_mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.tienda_mongodb.model.Producto;
import com.devsenior.tienda_mongodb.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public List<Producto> getAll() {
        return productoService.listarTodos();
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        
        return productoService.guardar(producto);
    }
}
