package com.etiya.rentacarr.business.rules;

import com.etiya.rentacarr.core.utilities.exceptions.BusinessException;
import com.etiya.rentacarr.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists"); //Java exception types
        }

    }
}
