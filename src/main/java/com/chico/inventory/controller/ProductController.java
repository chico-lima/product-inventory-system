package com.chico.inventory.controller;

import com.chico.inventory.dto.CreateProductDTO;
import com.chico.inventory.dto.ProductResponseDTO;
import com.chico.inventory.dto.UpdateProductDTO;
import com.chico.inventory.model.Product;
import com.chico.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public List<ProductResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Product create(@Valid @RequestBody CreateProductDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(
            @PathVariable("id") Long id,
            @RequestBody UpdateProductDTO dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
