package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Userss user;

    @ManyToOne
    @JoinColumn(name = "productId")
    private product product;

    private int quantity;

    private double amount;
    private String coupon;
    private Date date;
    private String status;


}