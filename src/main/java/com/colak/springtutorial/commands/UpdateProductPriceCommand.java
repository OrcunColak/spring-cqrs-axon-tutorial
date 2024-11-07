package com.colak.springtutorial.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
public class UpdateProductPriceCommand {
    @TargetAggregateIdentifier
    private final String productId;
    private final double price;

    public UpdateProductPriceCommand(String productId, double price) {
        this.productId = productId;
        this.price = price;
    }
}
