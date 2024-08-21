package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodInfoRepository extends JpaRepository<FoodInfo, Long> {
    Optional<FoodInfo> findByName(String name);
}
