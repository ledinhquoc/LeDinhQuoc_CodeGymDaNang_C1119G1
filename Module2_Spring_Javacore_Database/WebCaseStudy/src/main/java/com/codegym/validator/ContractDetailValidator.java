package com.codegym.validator;

import com.codegym.entity.ContractDetails.ContractDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContractDetailValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return ContractDetails.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ContractDetails contractDetails=(ContractDetails)target;
        if(contractDetails.getQuantity()<0){
            errors.rejectValue("quantity","quantity.negative");
        }
    }
}
