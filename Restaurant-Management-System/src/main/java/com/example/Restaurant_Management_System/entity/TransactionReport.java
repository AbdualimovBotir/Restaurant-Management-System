package com.example.Restaurant_Management_System.entity;

import com.example.Restaurant_Management_System.entity.abstractentity.MainAbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TransactionReport extends MainAbstractEntity {
    private Date transDate;
    private Customer customer;
    private Crew crew;
    private OrderDetails orderDetails;
    private Date reportDate;
}
