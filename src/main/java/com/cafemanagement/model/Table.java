package com.cafemanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@javax.persistence.Table(name = "tables")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private int chairsCount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
