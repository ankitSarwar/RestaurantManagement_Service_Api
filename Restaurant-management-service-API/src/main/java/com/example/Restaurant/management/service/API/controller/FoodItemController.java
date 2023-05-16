package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/create")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem createdFoodItem = foodItemService.createFoodItem(foodItem);
        return ResponseEntity.ok(createdFoodItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        Optional<FoodItem> foodItem = Optional.ofNullable(foodItemService.getFoodItemById(id));
        return foodItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    @PutMapping("/update")
    public ResponseEntity<FoodItem> updateFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(foodItem);
        if (updatedFoodItem != null) {
            return ResponseEntity.ok(updatedFoodItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.ok().build();
    }
}
