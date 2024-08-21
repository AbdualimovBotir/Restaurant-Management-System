package com.example.Restaurant_Management_System.repository;

import com.example.Restaurant_Management_System.entity.TransactionReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionReportRepository extends JpaRepository<TransactionReport, Long> {
}
