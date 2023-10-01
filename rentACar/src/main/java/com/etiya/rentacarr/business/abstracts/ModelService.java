package com.etiya.rentacarr.business.abstracts;

import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.requests.CreateModelRequest;
import com.etiya.rentacarr.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
