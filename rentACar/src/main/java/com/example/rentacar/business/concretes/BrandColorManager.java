package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandColorService;
import com.example.rentacar.business.requests.CreateBrandColorRequest;
import com.example.rentacar.business.requests.UpdateBrandColorRequest;
import com.example.rentacar.business.responses.GetAllBrandColorResponse;
import com.example.rentacar.business.responses.GetByIdBrandColorResponse;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.BrandColorRepository;
import com.example.rentacar.entities.concretes.BrandColor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandColorManager implements BrandColorService {

    private BrandColorRepository brandColorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandColorResponse> getAll() {

        List<BrandColor> brandColors= brandColorRepository.findAll();

        List<GetAllBrandColorResponse> brandColorsResponses = brandColors.stream()
                .map(brandColor -> modelMapperService.forResponse()
                        .map(brandColor, GetAllBrandColorResponse.class))
                .collect(Collectors.toList());
        return brandColorsResponses;
    }

    @Override
    public void add(CreateBrandColorRequest createBrandColorRequest) {
        BrandColor brandColor =this.modelMapperService.forRequest().map(createBrandColorRequest,BrandColor.class);
        this.brandColorRepository.save(brandColor);
    }

    @Override
    public void update(UpdateBrandColorRequest updateBrandColorRequest) {
    BrandColor brandColor =this.modelMapperService.forRequest().map(updateBrandColorRequest,BrandColor.class);
        this.brandColorRepository.save(brandColor);
    }

    @Override
    public void delete(int id) {
        this.brandColorRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandColorResponse getById(int id) {
        BrandColor brandColor = this.brandColorRepository.findById(id).orElseThrow();
       GetByIdBrandColorResponse response = this.modelMapperService.forResponse()
               .map(brandColor,GetByIdBrandColorResponse.class);
        return response;
    }
}
