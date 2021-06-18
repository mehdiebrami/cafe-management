package com.cafemanagement.service;

import com.cafemanagement.model.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> getAll();

}
