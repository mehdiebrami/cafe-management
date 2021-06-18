package com.cafemanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@javax.persistence.Table(name = "productInOrders")
public class ProductInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(value = EnumType.STRING)
    private ProductInOrderStatus productInOrderStatus = ProductInOrderStatus.ACTIVE;

}
