package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.repository.IFoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepository foodItemRepository;


    public FoodItem createFoodItem(FoodItem foodItem) {
        // Perform any validation or additional logic here
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }


    public FoodItem updateFoodItem(FoodItem foodItem) {
        // Check if the food item exists
        FoodItem existingFoodItem = foodItemRepository.findById(foodItem.getId()).orElse(null);
        if (existingFoodItem == null) {
            return null; // Return null if the food item doesn't exist
        }

        // Update the fields of the existing food item
        existingFoodItem.setTitle(foodItem.getTitle());
        existingFoodItem.setDescription(foodItem.getDescription());
        existingFoodItem.setPrice(foodItem.getPrice());

        // Save the updated food item
        return foodItemRepository.save(existingFoodItem);
    }

}
