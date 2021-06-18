package com.cafemanagement.service;


import com.cafemanagement.model.Order;
import com.cafemanagement.model.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> byOrderStatusAndTableId(OrderStatus orderStatus, long id);

    void createOrder(Order order);

    Optional<Order> getById(long id);

    List<Order> getWaiterOrder(long id);

    List<Order> getList();

}
