package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class OrderResponse {
    @Id
    private Long orderId;
    private Long userId;
    private int quantity;
    private Date date;
    private double amount;
    private String transactionId;
    private String status;
    private String coupon;


}
