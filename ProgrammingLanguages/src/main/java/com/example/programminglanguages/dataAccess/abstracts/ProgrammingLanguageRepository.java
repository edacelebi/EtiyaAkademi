package com.example.programminglanguages.dataAccess.abstracts;

import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    void add(ProgrammingLanguage programmingLanguage);
    void delete(int id) throws Exception;
    void update(int id ,ProgrammingLanguage programmingLanguage) throws Exception;
    List<ProgrammingLanguage>getAll();
   ProgrammingLanguage getById(int id);

}
