package com.colak.springtutorial.aggregate;

import com.colak.springtutorial.commands.CreateProductCommand;
import com.colak.springtutorial.commands.UpdateProductPriceCommand;
import com.colak.springtutorial.events.ProductCreatedEvent;
import com.colak.springtutorial.events.ProductPriceUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;

    public ProductAggregate() {
        // Required by Axon framework
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        AggregateLifecycle.apply(new ProductCreatedEvent(command.getProductId(), command.getName(), command.getPrice()));
    }

    @CommandHandler
    public void handle(UpdateProductPriceCommand command) {
        AggregateLifecycle.apply(new ProductPriceUpdatedEvent(command.getProductId(), command.getPrice()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.name = event.getName();
        this.price = event.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductPriceUpdatedEvent event) {
        this.price = event.getPrice();
    }
}
