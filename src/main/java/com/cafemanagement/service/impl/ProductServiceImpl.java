package com.cafemanagement.service.impl;

import com.cafemanagement.model.Product;
import com.cafemanagement.repository.ProductRepository;
import com.cafemanagement.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
