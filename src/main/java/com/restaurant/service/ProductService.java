package com.restaurant.service;

import com.restaurant.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(String category);

    Product getProduct(String id);

    void saveProduct(Product product);

    void saveEnhancedProduct(Product product);
}
