package com.example.Restaurant_Management_System.entity.abstractentity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class MainAbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    @CreationTimestamp
    // yaratilgan vaqtni saqlab qo'yadi. @Column(updatable=false) orqali jadvaldagi ma'lumot qayta tahrirlanganda shu ustundagi ma'lumot qayta tahrirlanishi o'chirib qo'yiladi.
    private Timestamp yaratilganVaqt;
    @UpdateTimestamp // jadvaldagi ma'lumot tahrirlangan vaqtni o'zida saqlaydi.
    private Timestamp tahrirlanganVaqt;
}
