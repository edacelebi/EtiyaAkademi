package com.example.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Table(name="brandColors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BrandColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
}
