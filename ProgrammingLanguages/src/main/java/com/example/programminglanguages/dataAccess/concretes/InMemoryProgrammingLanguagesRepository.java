package com.example.programminglanguages.dataAccess.concretes;

import com.example.programminglanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguagesRepository implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguageList;

    public InMemoryProgrammingLanguagesRepository() {
        programmingLanguageList = new ArrayList<ProgrammingLanguage>();
        programmingLanguageList.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguageList.add(new ProgrammingLanguage(2, "java"));
        programmingLanguageList.add(new ProgrammingLanguage(3, "Python"));
        programmingLanguageList.add(new ProgrammingLanguage(4, "C++"));

    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguageList.add(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        if (getById(id) != null) {
            programmingLanguageList.remove(getById(id));
            System.out.println("deleted");
        } else {
            throw new Exception("no language found to delete");
        }
    }

    @Override
    public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
        if (getById(id) != null) {

            for (ProgrammingLanguage value : programmingLanguageList) {
                if (value.getId() == id) {
                    value.setName(programmingLanguage.getName());
                    System.out.println("updated");
                }
            }

        } else {
            throw new Exception("language for id not found");
        }
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageList;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage value : programmingLanguageList) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }
}

//database