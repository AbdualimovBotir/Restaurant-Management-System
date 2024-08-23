package com.example.Restaurant_Management_System.service;

import com.example.Restaurant_Management_System.entity.FoodInfo;
import com.example.Restaurant_Management_System.entity.Menu;
import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.payload.MenuDto;
import com.example.Restaurant_Management_System.repository.FoodInfoRepository;
import com.example.Restaurant_Management_System.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    FoodInfoRepository foodInfoRepository;

    public ApiResponse addMenu(MenuDto menuDto) {
        Optional<FoodInfo> foodInfo = foodInfoRepository.findById(menuDto.getFoodInfoId());
        if (!foodInfo.isPresent()) {
            return new ApiResponse("Not found foodInfo Id", false);
        }
        Menu menu = new Menu(
                foodInfo.get(),
                menuDto.getDetails()
        );
        menuRepository.save(menu);
        return new ApiResponse("Saved menu", true);
    }

    public ApiResponse readMenu() {
        List<Menu> all = menuRepository.findAll();
        return new ApiResponse(all.toString(), true);
    }

    public ApiResponse editMenu(MenuDto menuDto, Long id) {
        Optional<Menu> menuId = menuRepository.findById(id);
        if (!menuId.isPresent()) {
            return new ApiResponse("Not found menu Id", false);
        }
        Menu menu = menuId.get();
        Optional<FoodInfo> foodId = foodInfoRepository.findById(menuDto.getFoodInfoId());
        if (foodId.get().getId()!=menu.getFoodInfoId().getId()) {
            menu.setFoodInfoId(foodId.get());
        }
        menu.setDetails(menuDto.getDetails());
        menuRepository.save(menu);
        return new ApiResponse("Edited menu", true);
    }

    public ApiResponse deleteMenu(Long id) {
        Optional<Menu> byId = menuRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Not found menu Id", false);
        }
        menuRepository.deleteById(id);
        return new ApiResponse("Deleted menu", true);
    }
}
