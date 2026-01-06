package com.chico.inventory.controller;

import com.chico.inventory.model.Product;
import com.chico.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> listAll() {
        return service.listAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }
}
