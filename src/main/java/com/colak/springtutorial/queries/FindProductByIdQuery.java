package com.colak.springtutorial.queries;

public class FindProductByIdQuery {
    private final String productId;

    public FindProductByIdQuery(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
