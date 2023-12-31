package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.requests.CreateCarRequest;
import com.example.rentacar.business.requests.UpdateCarRequest;
import com.example.rentacar.business.responses.GetAllCarsResponse;
import com.example.rentacar.business.responses.GetByIdCarsResponse;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.CarRepository;
import com.example.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars =carRepository.findAll();

        List<GetAllCarsResponse> carsResponses =cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());

        return carsResponses;
    }


    @Override
    public GetByIdCarsResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarsResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarsResponse.class);
        return response;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car =this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
                this.carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);

    }
}
