package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
List<GetAllModelsResponse> getAll();
void Add(CreateModelRequest createModelRequest);

    void add(CreateModelRequest createModelRequest);

    /*GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id); //direk id alıp günceller*/

}