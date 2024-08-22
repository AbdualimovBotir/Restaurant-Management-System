package com.example.Restaurant_Management_System.entity;

import com.example.Restaurant_Management_System.entity.abstractentity.MainAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment extends MainAbstractEntity {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private OrderDetails orderDetails;
    @ManyToOne
    private Delivery delivery;
    private int amount;
    private Date date;
}
