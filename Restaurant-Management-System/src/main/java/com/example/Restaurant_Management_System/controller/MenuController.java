package com.example.Restaurant_Management_System.controller;

import com.example.Restaurant_Management_System.payload.ApiResponse;
import com.example.Restaurant_Management_System.payload.MenuDto;
import com.example.Restaurant_Management_System.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @PostMapping("/addMenu")
    public HttpEntity<?> addMenu(@RequestBody MenuDto menuDto) {
        ApiResponse apiResponse=menuService.addMenu(menuDto);
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @GetMapping("/readMenu")
    public HttpEntity<?> readMenu() {
        ApiResponse apiResponse=menuService.readMenu();
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @PutMapping("/editMenu/{id}")
    public HttpEntity<?> editMenu(@RequestBody MenuDto menuDto, @PathVariable Long id) {
        ApiResponse apiResponse=menuService.editMenu(menuDto, id);
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteMenu/{id}")
    public HttpEntity<?> deleteMenu(@PathVariable Long id) {
        ApiResponse apiResponse=menuService.deleteMenu(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:209).body(apiResponse.getXabar());
    }
}
