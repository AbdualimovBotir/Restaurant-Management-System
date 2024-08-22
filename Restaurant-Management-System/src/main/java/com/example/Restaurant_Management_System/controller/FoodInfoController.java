package com.example.Restaurant_Management_System.controller;

import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.payload.FoodInfoDto;
import com.example.Restaurant_Management_System.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodInfo")
public class FoodInfoController {
    @Autowired
    FoodInfoService foodInfoService;
    @PostMapping("/addFoodInfo")
    public HttpEntity<?> addFoodInfo(@RequestBody FoodInfoDto foodInfoDto) {
        ApiResponse apiResponse=foodInfoService.addFoodInfo(foodInfoDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @GetMapping("/readAllFoodInfo")
    public HttpEntity<?> readAllFoodInfo() {
        ApiResponse apiResponse=foodInfoService.readAllFoodInfo();
        return  ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @PutMapping("/editFoodInfo/{id}")
    public HttpEntity<?> editFoodInfo(@RequestBody FoodInfoDto foodInfoDto, @PathVariable long id) {
        ApiResponse apiResponse=foodInfoService.editFoodInfo(foodInfoDto, id);
        return  ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteFoodInfo/{id}")
    public HttpEntity<?> deleteFoodInfo(@PathVariable long id) {
        ApiResponse apiResponse=foodInfoService.deleteFoodInfo(id);
        return  ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
}
