package com.example.Restaurant_Management_System.entity;

import com.example.Restaurant_Management_System.entity.abstractentity.MainAbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer extends MainAbstractEntity {
    private String name;
    private String contact;
    private String address;
    private String username;
    private String password;
}
