package com.cafemanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@javax.persistence.Table(name = "users",
        indexes = {@Index(name = "username_index", columnList = "username", unique = true)
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
