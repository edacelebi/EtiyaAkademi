package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.business.requests.CreateMaintenanceRequest;
import com.example.rentacar.business.requests.UpdateMaintenanceRequest;
import com.example.rentacar.business.responses.GetAllMaintenancesResponse;
import com.example.rentacar.business.responses.GetByIdMaintenanceResponse;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.example.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private MaintenanceRepository maintenanceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();

        List<GetAllMaintenancesResponse> getAllMaintenancesResponses = maintenances.stream()
                .map(maintenance -> this.modelMapperService.forResponse().map(maintenance, GetAllMaintenancesResponse.class)).collect(Collectors.toList());
        return getAllMaintenancesResponses;
    }

    @Override
    public GetByIdMaintenanceResponse getById(int id) {
        Maintenance maintenance = this.maintenanceRepository.findById(id).orElseThrow();

        GetByIdMaintenanceResponse getByIdMaintenanceResponse = this.modelMapperService.forResponse().map(maintenance, GetByIdMaintenanceResponse.class);

        return getByIdMaintenanceResponse;
    }

    @Override
    public void add(CreateMaintenanceRequest createMaintenanceRequest) {
        Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest,Maintenance.class);
        this.maintenanceRepository.save(maintenance);
    }

    @Override
    public void update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest,Maintenance.class);
        this.maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(int id) {
        this.maintenanceRepository.deleteById(id);

    }
}
