package com.cafemanagement.service.impl;

import com.cafemanagement.model.ProductInOrder;
import com.cafemanagement.repository.ProductInOrderRepository;
import com.cafemanagement.service.ProductInOrderService;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {


    private final ProductInOrderRepository productInOrderRepository;

    public ProductInOrderServiceImpl(ProductInOrderRepository productInOrderRepository) {
        this.productInOrderRepository = productInOrderRepository;
    }


    @Override
    public void addProductInOrder(ProductInOrder product) {
        productInOrderRepository.save(product);
    }

}
