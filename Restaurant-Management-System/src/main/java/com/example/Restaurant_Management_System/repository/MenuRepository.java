package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
