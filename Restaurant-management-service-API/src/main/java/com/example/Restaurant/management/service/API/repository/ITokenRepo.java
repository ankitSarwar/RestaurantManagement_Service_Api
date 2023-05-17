package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.Orders;
import com.example.Restaurant.management.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo  extends JpaRepository<AuthenticationToken, Long> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);

}
