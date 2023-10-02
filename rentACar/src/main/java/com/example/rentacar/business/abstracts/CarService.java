package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateCarRequest;
import com.example.rentacar.business.requests.UpdateCarRequest;
import com.example.rentacar.business.responses.GetAllCarsResponse;
import com.example.rentacar.business.responses.GetByIdCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse>getAll();
    GetByIdCarsResponse getById(int id);
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);

}
