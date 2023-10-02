package com.example.programminglanguages.webApi.concretes;

import com.example.programminglanguages.business.abstracts.ProgrammingLanguageService;
import com.example.programminglanguages.business.requests.CreateProgrammingLanguageRequest;
import com.example.programminglanguages.business.requests.UpdateProgrammingLanguageRequest;
import com.example.programminglanguages.business.responses.GetAllProgrammingLanguageResponse;
import com.example.programminglanguages.business.responses.GetByIdProgrammingLanguageResponse;
import com.example.programminglanguages.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programmingLanguages")
public class ProgrammingLanguagesController {


    private ProgrammingLanguageService programmingLanguageService;
    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return programmingLanguageService.getAll();
    }


    @PostMapping(path = "/add")
    public void addProgrammingLanguage(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @GetMapping(path = "/getById/{id}")
    public GetByIdProgrammingLanguageResponse getById(@RequestParam int id) {
        return programmingLanguageService.getById(id);
    }


    @PostMapping(path = "/update/{id}")
    public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }








    // add post
    // database get







}
