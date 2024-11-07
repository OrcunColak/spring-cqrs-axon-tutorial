package com.colak.springtutorial.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String productId;
    private final String name;
    private final double price;

    public CreateProductCommand(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
