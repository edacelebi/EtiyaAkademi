package com.example.rentacar.business.requests;

import com.example.rentacar.entities.concretes.Maintenance;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    private String plate;
    private double dailyPrice;
    private int modelYear;
    private int modelId;
    private int maintenanceId;

}
