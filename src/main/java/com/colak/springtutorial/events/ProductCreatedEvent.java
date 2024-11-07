package com.colak.springtutorial.events;

import lombok.Getter;

@Getter
public class ProductCreatedEvent {
    private final String productId;
    private final String name;
    private final double price;

    public ProductCreatedEvent(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}