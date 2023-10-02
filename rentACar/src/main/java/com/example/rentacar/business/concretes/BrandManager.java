package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.BrandRepository;
import com.example.rentacar.entities.concretes.Brand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository; //carColorRepository
    private ModelMapperService modelMapperService; //

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands= brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());

        return brandsResponses;
        }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
       Brand brand =this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
       this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand =this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

}

//    @Autowired
//    public BrandManager(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }


//    List<GetAllBrandsResponse> brandsResponse = new ArrayList<>(); //boş listeyi
//        for( Brand brandItem :brands){  //analisteyi dönerek dolduruyorum
//                GetAllBrandsResponse item = new GetAllBrandsResponse();
//                item.setId(brandItem.getId());
//                item.setName(brandItem.getName());
//                brandsResponse.add(item);
//                }
//
//                return brandsResponse;

//id =id name =name
