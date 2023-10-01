package com.etiya.rentacarr.business.concretes;

import com.etiya.rentacarr.business.abstracts.ModelService;
import com.etiya.rentacarr.business.requests.CreateModelRequest;
import com.etiya.rentacarr.business.responses.GetAllBrandsResponse;
import com.etiya.rentacarr.business.responses.GetAllModelsResponse;
import com.etiya.rentacarr.core.utilities.mappers.ModelMapperService;
import com.etiya.rentacarr.dataAccess.abstracts.ModelRepsitory;
import com.etiya.rentacarr.entities.concretes.Brand;
import com.etiya.rentacarr.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepsitory modelRepsitory;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepsitory.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream().map(model -> this.modelMapperService.forResponse()
                .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepsitory.save(model);
    }
}
