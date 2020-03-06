package com.codegym.validator;

import com.codegym.entity.Services.Services;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ServiceValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Services.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Services services=(Services)target;

        if(services.getArea_used ()<0){
            errors.rejectValue("area","area.negative");
        }
        if(services.getNumber_floors ()<0){
            errors.rejectValue("number_floor","number_floor.negative");
        }
        if(services.getNumber_max_people ()<0){
            errors.rejectValue("number_max_people","number_max_people.negative");
        }
        if(services.getRental_costs ()<0){
            errors.rejectValue("rental_costs","rental_costs.negative");
        }

    }
}