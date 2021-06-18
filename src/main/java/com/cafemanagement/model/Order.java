package com.cafemanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@javax.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_Id")
    private Table table;
 }
