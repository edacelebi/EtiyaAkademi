package com.example.rentacar.business.abstracts;


import com.example.rentacar.business.requests.CreateMaintenanceRequest;
import com.example.rentacar.business.requests.UpdateMaintenanceRequest;
import com.example.rentacar.business.responses.GetAllMaintenancesResponse;
import com.example.rentacar.business.responses.GetByIdMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenancesResponse> getAll();
    GetByIdMaintenanceResponse getById(int id);
    void add(CreateMaintenanceRequest createMaintenanceRequest);
    void update(UpdateMaintenanceRequest updateMaintenanceRequest);
    void delete(int id);
}
