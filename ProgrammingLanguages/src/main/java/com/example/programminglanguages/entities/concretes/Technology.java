package com.example.programminglanguages.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
