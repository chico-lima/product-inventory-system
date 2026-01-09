package com.chico.inventory.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public ProductResponseDTO(Long id, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }
}
