package com.example.programminglanguages.business.concretes;

import com.example.programminglanguages.business.abstracts.ProgrammingLanguageService;
import com.example.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import com.example.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import com.example.programminglanguages.business.responses.GetAllProgrammingLanguageResponse;
import com.example.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;
import com.example.programminglanguages.core.utilities.mappers.ModelMapperService;
import com.example.programminglanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();

        List<GetAllProgrammingLanguageResponse> programmingLanguageResponse = programmingLanguages.stream()
                .map(language -> this.modelMapperService.forResponse()
                        .map(language, GetAllProgrammingLanguageResponse.class))
                .collect(Collectors.toList());
        return programmingLanguageResponse;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).orElseThrow();
        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = this.modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
        return getByIdProgrammingLanguageResponse;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
                .map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
                .map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        this.programmingLanguageRepository.deleteById(id);
    }
}

//iş kuralları
//dependency injection
