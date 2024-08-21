package com.example.Restaurant_Management_System.service;

import com.example.Restaurant_Management_System.entity.FoodInfo;
import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.repository.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodInfoService {
    @Autowired
    FoodInfoRepository foodInfoRepository;

    public ApiResponse addFoodInfo(FoodInfo foodInfo) {
        Optional<FoodInfo> foodName = foodInfoRepository.findByName(foodInfo.getName());
        if (foodName.isPresent()) {
            return new ApiResponse("Already available", false);
        }else {
            foodInfoRepository.save(foodInfo);
        }
        return null;
    }
}
