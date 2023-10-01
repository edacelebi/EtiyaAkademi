package com.etiya.rentacarr.webApi.controllers;

import com.etiya.rentacarr.business.abstracts.ModelService;
import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.requests.CreateModelRequest;
import com.etiya.rentacarr.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
