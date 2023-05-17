package com.example.Restaurant.management.service.API.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    private  String Address;
    private String userContact;


    public User(String username, String password, String email, String address, String userContact) {
        this.username = username;
        this.password = password;
        this.email = email;
        Address = address;
        this.userContact = userContact;
    }

}
