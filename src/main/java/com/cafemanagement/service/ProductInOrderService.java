package com.cafemanagement.service;

import com.cafemanagement.model.ProductInOrder;

public interface ProductInOrderService {

    void createProductInOrder(ProductInOrder product);

    ProductInOrder editProductInOrder(ProductInOrder product);

}
