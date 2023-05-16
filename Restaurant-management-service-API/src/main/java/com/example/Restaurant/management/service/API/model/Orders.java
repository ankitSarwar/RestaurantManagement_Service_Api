package com.example.Restaurant.management.service.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int quantity;

    private String status;

    // Date and time fields (optional)
    private LocalDateTime createdDateTime;

    @ManyToOne(cascade =CascadeType.ALL)
    private FoodItem foodItem;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

//    SignInInput
}