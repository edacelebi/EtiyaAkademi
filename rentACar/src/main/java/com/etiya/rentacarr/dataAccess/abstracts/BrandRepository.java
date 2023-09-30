package com.etiya.rentacarr.dataAccess.abstracts;


import com.etiya.rentacarr.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
