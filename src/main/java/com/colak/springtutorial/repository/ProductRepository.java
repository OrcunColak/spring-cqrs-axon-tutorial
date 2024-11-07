package com.colak.springtutorial.repository;

import com.colak.springtutorial.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    List<Product> list = new ArrayList<>(List.of(new Product("1", "product1", 10)));

    public List<Product> findAll() {
        return list;
    }

    public Optional<Product> findById(String productId) {
        return list.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }
}
