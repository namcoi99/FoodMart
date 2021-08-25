package com.springboot.server.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDER")
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;
    private Long userID;
    private Long productID;
    private Long quantity;
    private Long total;

}
