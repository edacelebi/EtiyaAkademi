package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.BrandColorService;
import com.example.rentacar.business.requests.CreateBrandColorRequest;
import com.example.rentacar.business.requests.UpdateBrandColorRequest;
import com.example.rentacar.business.responses.GetAllBrandColorResponse;
import com.example.rentacar.business.responses.GetByIdBrandColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brandColors")
public class BrandColorsController {

    private BrandColorService brandColorService;
    @GetMapping("/getAll")
    public List<GetAllBrandColorResponse> getAll(){
        return brandColorService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandColorResponse getById(@PathVariable int id){
        return brandColorService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandColorRequest createBrandColorRequest){
        this.brandColorService.add(createBrandColorRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateBrandColorRequest updateBrandColorRequest){
        this.brandColorService.update(updateBrandColorRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandColorService.delete(id);
    }


}

