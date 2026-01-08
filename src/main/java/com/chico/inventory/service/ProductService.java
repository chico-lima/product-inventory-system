package com.chico.inventory.service;

import com.chico.inventory.dto.CreateProductDTO;
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

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product create(CreateProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        return repository.save(product);
    }

}
