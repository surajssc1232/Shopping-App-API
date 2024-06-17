package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Inventory {
    @Id
    private int ordered;

    private double price;
    private int available;

}
