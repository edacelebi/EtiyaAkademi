package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse>getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
   GetByIdBrandResponse getById(int id);








}
