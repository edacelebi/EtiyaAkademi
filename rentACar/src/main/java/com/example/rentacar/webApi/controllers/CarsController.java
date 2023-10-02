package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.requests.CreateCarRequest;
import com.example.rentacar.business.requests.UpdateCarRequest;
import com.example.rentacar.business.responses.GetAllCarsResponse;
import com.example.rentacar.business.responses.GetByIdCarsResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){
        return carService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCarsResponse getById(@PathVariable int id){
        return carService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);

    }
    @PutMapping()
    public void update (@RequestBody @Valid UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);

    }
}
