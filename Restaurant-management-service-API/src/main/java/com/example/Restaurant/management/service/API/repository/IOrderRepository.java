package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {
}
