package com.example.programminglanguages.business.abstracts;

import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    void add(ProgrammingLanguage programmingLanguage) throws Exception;

    void delete(int id) throws Exception;

    void update(int id , ProgrammingLanguage programmingLanguage) throws Exception;

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id);

}

//Signature