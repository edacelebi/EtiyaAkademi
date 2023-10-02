package com.example.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    List<Model> models;

}

    //Lombok, Java programlama dilinde kullanılan bir kütüphanedir ve
    //kod tekrarını azaltmayı, kodu temizlemeyi ve Java sınıflarını daha basit hale getirmeyi amaçlar.
    //@Autowired: Spring Framework için kullanılır ve bağımlılık enjeksiyonunu belirtir.