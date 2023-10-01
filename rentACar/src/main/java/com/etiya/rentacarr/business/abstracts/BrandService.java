package com.etiya.rentacarr.business.abstracts;


import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.requests.UpdateBrandRequest;
import com.etiya.rentacarr.business.responses.GetAllBrandsResponse;
import com.etiya.rentacarr.business.responses.GetByIdBrandResponse;
import com.etiya.rentacarr.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
