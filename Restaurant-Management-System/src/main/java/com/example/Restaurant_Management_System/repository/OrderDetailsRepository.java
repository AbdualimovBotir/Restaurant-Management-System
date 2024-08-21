package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
