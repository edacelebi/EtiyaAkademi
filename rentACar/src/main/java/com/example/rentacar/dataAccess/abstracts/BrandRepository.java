package com.example.rentacar.dataAccess.abstracts;

import com.example.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>{
    boolean existsByName (String name);
}

/*
   --JpaRepository, Spring Data JPA tarafından sağlanan bir arabirimdir
    ve veri tabanı işlemlerini kolaylaştırmak için kullanılır.
    -Primary Key :Integer
   --Spring Data JPA, Java tabanlı Spring Framework kullanılarak
    veritabanı işlemlerini kolaylaştırmak ve veri erişim katmanını
    (data access layer) daha etkili bir şekilde yönetmek için kullanılan bir projedir.

 */