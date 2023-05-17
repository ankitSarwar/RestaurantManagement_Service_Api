package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.Orders;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.repository.IOrderRepository;
import com.example.Restaurant.management.service.API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IUserRepository userRepository;

    public Orders createOrder(Orders order) {

        Long userId = order.getUser().getUserId();
        User myUser = userRepository.findByUserId(userId);
        if(myUser!=null){
            order.setUser(myUser);
            orderRepository.save(order);
        }else{
            throw new IllegalStateException("user does not exists!!!");
        }
        return order;
    }




    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        Optional<Orders> orderDelete=orderRepository.findById(id);
        if(orderDelete.isPresent()){
            orderRepository.delete(orderDelete.get());
        }
//        orderRepository.deleteById(id);
    }

    public Orders updateOrder(Long id,Orders order) {
        Optional<Orders> existById=orderRepository.findById(id);
        if(existById.isPresent()){
            Orders order1= existById.get();
            order1.setUser(order.getUser());
            order1.setStatus(order.getStatus());
            order1.setCreatedDateTime(order.getCreatedDateTime());
            order1.setQuantity(order.getQuantity());
            order1.setFoodItem(order.getFoodItem());
        }
        return orderRepository.save(order);
    }
}

