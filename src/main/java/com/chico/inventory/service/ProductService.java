package com.chico.inventory.service;

import com.chico.inventory.dto.CreateProductDTO;
import com.chico.inventory.dto.ProductResponseDTO;
import com.chico.inventory.dto.UpdateProductDTO;
import com.chico.inventory.exception.ResourceNotFoundException;
import com.chico.inventory.model.Product;
import com.chico.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(p -> new ProductResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getQuantity(),
                        p.getPrice()
                ))
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public Product create(CreateProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        return repository.save(product);
    }

    public ProductResponseDTO update(Long id, UpdateProductDTO dto) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        Product updated = repository.save(product);

        return new ProductResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getQuantity(),
                updated.getPrice()
        );
    }

    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id)
                );

        repository.delete(product);
    }



}
