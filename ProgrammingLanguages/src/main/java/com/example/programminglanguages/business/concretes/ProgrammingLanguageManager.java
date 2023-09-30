package com.example.programminglanguages.business.concretes;

import com.example.programminglanguages.business.abstracts.ProgrammingLanguageService;
import com.example.programminglanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {

        if (programmingLanguage.getName() == null) {
            throw new Exception("Empty value cannot be made");
        }

        for (ProgrammingLanguage value : programmingLanguageRepository.getAll()) {
            if (programmingLanguage.getName() == value.getName()) {
                throw new Exception("Existing language cannot be added again");
            }

            programmingLanguageRepository.add(programmingLanguage);
            System.out.println("Added");

        }
    }

    @Override
    public void delete(int id) throws Exception {
        programmingLanguageRepository.delete(id);
    }

    @Override
    public void update( int id ,ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageRepository.update( id,programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }
}

//iş kuralları
//dependency injection
