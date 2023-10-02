package com.example.programminglanguages.business.abstracts;

import com.example.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import com.example.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import com.example.programminglanguages.business.responses.GetAllProgrammingLanguageResponse;
import com.example.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguageResponse> getAll();

    GetByIdProgrammingLanguageResponse getById(int id);

    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

    void delete(int id);

}

//Signature