package com.example.Restaurant_Management_System.entity;

import com.example.Restaurant_Management_System.entity.abstractentity.MainAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Crew crew;
    @OneToOne
    private OrderDetails orderDetails;
    private Date reportDate;
}
