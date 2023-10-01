package com.etiya.rentacarr.webApi.controllers;

import com.etiya.rentacarr.business.abstracts.BrandService;
import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.requests.UpdateBrandRequest;
import com.etiya.rentacarr.business.responses.GetAllBrandsResponse;
import com.etiya.rentacarr.business.responses.GetByIdBrandResponse;
import com.etiya.rentacarr.entities.concretes.Brand;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        //IoC
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }


}
