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
public class OrderDetails extends MainAbstractEntity {
    @ManyToOne
    private Crew crew;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private FoodInfo foodInfo;
    private Date date;
    private String status;
}
