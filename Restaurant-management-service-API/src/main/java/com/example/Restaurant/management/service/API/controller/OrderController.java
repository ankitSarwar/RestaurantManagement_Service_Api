package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.Orders;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.service.OrderService;
import com.example.Restaurant.management.service.API.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@Valid @RequestParam String email,@RequestParam String token, @RequestBody Orders order) {

        HttpStatus status;
        String msg = "";
        if (tokenService.authenticate(email, token)) {

            User user =  tokenService.findUserByToken(token);
            order.setUser(user);
            Orders createdOrder = orderService.createOrder(order);
            msg = " order created successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Optional<Orders> order = Optional.ofNullable(orderService.getOrderById(orderId));
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        Orders updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

}
