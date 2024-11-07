package com.colak.springtutorial.controller;

import com.colak.springtutorial.commands.CreateProductCommand;
import com.colak.springtutorial.commands.UpdateProductPriceCommand;
import com.colak.springtutorial.model.Product;
import com.colak.springtutorial.queries.FindAllProductsQuery;
import com.colak.springtutorial.queries.FindProductByIdQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public ProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public CompletableFuture<String> createProduct(@RequestBody CreateProductCommand command) {
        return commandGateway.send(command);
    }

    @PutMapping("/{id}/price")
    public CompletableFuture<Void> updatePrice(@PathVariable String id, @RequestBody double price) {
        return commandGateway.send(new UpdateProductPriceCommand(id, price));
    }

    // http://localhost:8080/products
    @GetMapping
    public CompletableFuture<List<Product>> findAll() {
        return queryGateway.query(new FindAllProductsQuery(), ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> findById(@PathVariable String id) {
        return queryGateway.query(new FindProductByIdQuery(id), ResponseTypes.instanceOf(Product.class));
    }
}

