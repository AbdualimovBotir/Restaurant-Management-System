package com.example.Restaurant_Management_System.controller;

import com.example.Restaurant_Management_System.entity.FoodInfo;
import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodInfo")
public class FoodInfoController {
    @Autowired
    FoodInfoService foodInfoService;
    @PostMapping("/addFoodInfo")
    public HttpEntity<?> addFoodInfo(@RequestBody FoodInfo foodInfo) {
        ApiResponse apiResponse=foodInfoService.addFoodInfo(foodInfo);
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
}
