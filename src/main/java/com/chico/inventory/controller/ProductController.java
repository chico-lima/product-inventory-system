package com.chico.inventory.controller;

import com.chico.inventory.dto.CreateProductDTO;
import com.chico.inventory.model.Product;
import com.chico.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public Product create(@Valid @RequestBody CreateProductDTO dto) {
        return service.create(dto);
    }

}
