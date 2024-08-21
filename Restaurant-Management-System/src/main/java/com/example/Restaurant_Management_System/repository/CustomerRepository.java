package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
