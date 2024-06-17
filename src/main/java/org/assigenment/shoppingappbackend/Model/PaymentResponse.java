package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PaymentResponse {
    @Id
    private Long userId;
    private Long orderId;
    private String transactionId;
    private String status;
    private String description;
    private double amount;


}
