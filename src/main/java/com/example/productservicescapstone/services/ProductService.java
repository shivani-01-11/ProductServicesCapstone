package com.example.productservicescapstone.services;

import com.example.productservicescapstone.exceptions.ProductNotFoundException;
import com.example.productservicescapstone.modules.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String name, String description, double price,
                          String imageUrl, String category);

}
