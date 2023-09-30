package com.etiya.rentacarr.webApi.controllers;

import com.etiya.rentacarr.business.abstracts.BrandService;
import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.responses.GetAllBrandsResponse;
import com.etiya.rentacarr.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<GetAllBrandsResponse> getAll() {
        //IoC
        return brandService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
}
