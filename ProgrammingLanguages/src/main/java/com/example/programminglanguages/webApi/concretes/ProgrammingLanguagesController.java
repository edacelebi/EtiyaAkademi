package com.example.programminglanguages.webApi.concretes;

import com.example.programminglanguages.business.abstracts.ProgrammingLanguageService;
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
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }


    @PostMapping(path = "/add")
    public void addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.add(programmingLanguage);
    }

    @GetMapping(path = "/getById/{id}")
    public ProgrammingLanguage getById(@RequestParam int id) {
        return programmingLanguageService.getById(id);
    }


    @PostMapping(path = "/update/{id}")
    public void update(@PathVariable int id,@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.update(id, programmingLanguage);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }








    // add post
    // database get







}
