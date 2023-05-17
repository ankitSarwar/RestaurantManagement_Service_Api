package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.repository.IFoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String  deleteFoodItem(Long id) {
        if(id !=null) {
            foodItemRepository.deleteById(id);
            return "Deleted!!!";
        }
        else{
            return "Id not exists!!!";
        }
    }


    public FoodItem updateFoodItem(Long foodId, FoodItem foodItem) {
        Optional<FoodItem> existingFood = foodItemRepository.findById(foodId);
        if(existingFood.isPresent()){
            FoodItem foodItem1=existingFood.get();
            foodItem1.setTitle(foodItem.getTitle());
            foodItem1.setPrice(foodItem.getPrice());
            foodItem1.setDescription(foodItem.getDescription());
            foodItem1.setDummyImageUrl(foodItem.getDummyImageUrl());
            foodItem1.setCreatedDateTime(foodItem.getCreatedDateTime());
            return foodItemRepository.save(foodItem1);
        }
            return null;
    }



}
