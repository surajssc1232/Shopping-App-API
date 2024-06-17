package org.assigenment.shoppingappbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Userss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "userId")
    private Long userId;

}