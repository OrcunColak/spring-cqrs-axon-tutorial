package com.colak.springtutorial.service;

import com.colak.springtutorial.model.Product;
import com.colak.springtutorial.queries.FindAllProductsQuery;
import com.colak.springtutorial.queries.FindProductByIdQuery;
import com.colak.springtutorial.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<Product> handle(FindAllProductsQuery query) {
        return productRepository.findAll();
    }

    @QueryHandler
    public Product handle(FindProductByIdQuery query) {
        return productRepository.findById(query.getProductId()).orElse(null);
    }
}

