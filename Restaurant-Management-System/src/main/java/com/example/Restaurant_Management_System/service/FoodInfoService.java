package com.example.Restaurant_Management_System.service;

import com.example.Restaurant_Management_System.entity.FoodInfo;
import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.payload.FoodInfoDto;
import com.example.Restaurant_Management_System.repository.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodInfoService {
    @Autowired
    FoodInfoRepository foodInfoRepository;

    public ApiResponse addFoodInfo(FoodInfoDto foodInfoDto) {
        Optional<FoodInfo> foodName = foodInfoRepository.findByName(foodInfoDto.getName());
        if (foodName.isPresent()) {
            return new ApiResponse("Already available", false);
        }else {
            FoodInfo foodInfo = new FoodInfo();
            foodInfo.setName(foodInfoDto.getName());
            foodInfo.setStatus(foodInfoDto.getStatus());
            foodInfo.setPrice(foodInfoDto.getPrice());
            foodInfoRepository.save(foodInfo);
            return new ApiResponse("Successfully added foodInfo", true);
        }
    }

    public ApiResponse readAllFoodInfo() {
        List<FoodInfo> all = foodInfoRepository.findAll();
        return new ApiResponse(all.toString(), true);
    }

    public ApiResponse editFoodInfo(FoodInfoDto foodInfoDto, long id) {
        Optional<FoodInfo> findFoodId = foodInfoRepository.findById(id);
        FoodInfo foodInfo = findFoodId.get();
        if (findFoodId.isPresent()) {
            if(foodInfoDto.getName()=="" || foodInfoDto.getName()==null || foodInfoDto.getName()==findFoodId.get().getName()){
                if (foodInfoDto.getStatus()==findFoodId.get().getStatus()){
                    if (foodInfoDto.getPrice()==findFoodId.get().getPrice()){
                        return new ApiResponse("Already available", false);
                    }
                    foodInfo.setPrice(foodInfoDto.getPrice());
                    foodInfoRepository.save(foodInfo);
                    return new ApiResponse("Successfully updated foodInfo: Price", true);
                }
                foodInfo.setStatus(foodInfoDto.getStatus());
                foodInfo.setPrice(foodInfoDto.getPrice());
                foodInfoRepository.save(foodInfo);
                return new ApiResponse("Successfully updated foodInfo: Price and Status", true);
            }
            foodInfo.setName(foodInfoDto.getName());
            foodInfo.setStatus(foodInfoDto.getStatus());
            foodInfo.setPrice(foodInfoDto.getPrice());
        }
        foodInfoRepository.save(foodInfo);
        return new ApiResponse("Successfully updated foodInfo", true);
    }

    public ApiResponse deleteFoodInfo(long id) {
        Optional<FoodInfo> byId = foodInfoRepository.findById(id);
        if (byId.isPresent()) {
            foodInfoRepository.deleteById(byId.get().getId());
            return new ApiResponse("Successfully deleted foodInfo", true);
        }
        return new ApiResponse("Not found id!", true);
    }
}
