package com.etiya.rentacarr.business.concretes;

import com.etiya.rentacarr.business.abstracts.BrandService;
import com.etiya.rentacarr.business.requests.CreateBrandRequest;
import com.etiya.rentacarr.business.responses.GetAllBrandsResponse;
import com.etiya.rentacarr.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacarr.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service//bu sınıf bir business nesnesidir.
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //iş kuralları yazılacak
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand:brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);


        }
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(GetAllBrandsResponse getAllBrandsResponse) {

    }
}
