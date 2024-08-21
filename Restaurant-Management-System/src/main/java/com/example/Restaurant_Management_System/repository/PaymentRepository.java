package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
