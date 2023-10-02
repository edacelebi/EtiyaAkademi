package com.example.programminglanguages.webApi.concretes;

import com.example.programminglanguages.business.abstracts.TechnologyService;
import com.example.programminglanguages.business.requests.CreateTechnologyRequest;
import com.example.programminglanguages.business.requests.UpdateTechnologyRequest;
import com.example.programminglanguages.business.responses.GetAllTechnologyResponse;
import com.example.programminglanguages.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {
    private TechnologyService technologyService;


    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateTechnologyRequest createTechnologyRequest) {
        this.technologyService.add(createTechnologyRequest);
    }

    @GetMapping("/{id}")
    public GetByIdTechnologyResponse getById(@PathVariable int id) {
        return technologyService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) {
        this.technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.technologyService.delete(id);
    }
}
