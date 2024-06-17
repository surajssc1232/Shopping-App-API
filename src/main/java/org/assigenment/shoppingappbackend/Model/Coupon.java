package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Coupon {
    @Id
    private String code;
    private int discountPercentage;

}