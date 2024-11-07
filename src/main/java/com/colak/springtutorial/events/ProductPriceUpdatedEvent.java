package com.colak.springtutorial.events;

import lombok.Getter;

@Getter
public class ProductPriceUpdatedEvent {
    private final String productId;
    private final double price;

    public ProductPriceUpdatedEvent(String productId, double price) {
        this.productId = productId;
        this.price = price;
    }
}
