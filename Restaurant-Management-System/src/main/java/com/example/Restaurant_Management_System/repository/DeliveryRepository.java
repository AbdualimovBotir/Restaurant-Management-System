package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}