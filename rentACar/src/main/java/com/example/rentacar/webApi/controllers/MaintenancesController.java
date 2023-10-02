package com.example.rentacar.webApi.controllers;

import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.business.requests.CreateMaintenanceRequest;
import com.example.rentacar.business.requests.UpdateMaintenanceRequest;
import com.example.rentacar.business.responses.GetAllMaintenancesResponse;
import com.example.rentacar.business.responses.GetByIdMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenancesController {
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<GetAllMaintenancesResponse> getAll(){
        return maintenanceService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdMaintenanceResponse getById(@PathVariable int id){
        return maintenanceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        this.maintenanceService.add(createMaintenanceRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest){
        this.maintenanceService.update(updateMaintenanceRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.maintenanceService.delete(id);
    }
}
