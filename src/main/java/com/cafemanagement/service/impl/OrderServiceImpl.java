package com.cafemanagement.service.impl;

import com.cafemanagement.model.Order;
import com.cafemanagement.model.OrderStatus;
import com.cafemanagement.repository.OrderRepository;
import com.cafemanagement.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> byOrderStatusAndTableId(OrderStatus orderStatus, long id) {
        List<Order> byOrderStatusAndTableId = orderRepository.findByOrderStatusAndTableId(orderStatus, id);
        return byOrderStatusAndTableId;
    }

    @Override
    public void createOrder(Order order) {
        List<Order> orders = byOrderStatusAndTableId(OrderStatus.OPEN, order.getTable().getId());
        if (orders.isEmpty()) {
            order.setOrderStatus(OrderStatus.OPEN);
            orderRepository.save(order);
        }
    }

    @Override
    public Optional<Order> getById(long id) {
        return orderRepository.findById(id);

    }

    @Override
    public List<Order> getWaiterOrder(long id) {
        return orderRepository.findAllByTable_UserId(id);

    }

    @Override
    public List<Order> getList() {
        return orderRepository.findAll();
    }

}
