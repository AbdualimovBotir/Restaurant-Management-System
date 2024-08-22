package com.example.Restaurant_Management_System.payload;

import lombok.Data;

@Data
public class FoodInfoDto {
    private String name;
    private int status;
    private int price;
}
/*
"name": "Osh",
"status": 10,
"price": 30000
 */