package com.etiya.rentacarr.dataAccess.abstracts;

import com.etiya.rentacarr.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepsitory extends JpaRepository<Model,Integer> {
}
