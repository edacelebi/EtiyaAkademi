package com.example.programminglanguages.dataAccess.abstracts;

import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {



}
