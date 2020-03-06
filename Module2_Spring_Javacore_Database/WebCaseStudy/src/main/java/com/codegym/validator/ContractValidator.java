package com.codegym.validator;

import com.codegym.entity.Contracts.Contracts;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractValidator implements Validator {
    @Override
    public boolean supports(Class< ? > aClass) {
        return Contracts.class.isAssignableFrom (aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
            Contracts contracts = (Contracts)o;
            Date beginDate = null;
            Date endDate = null;

        if (contracts.getContract_date_end ().equals ("")){
                errors.rejectValue ("endDate","date.inValid");
        }else {
                try {
                    endDate = new SimpleDateFormat ("dd/MM/yyyy").parse (contracts.getContract_date_end ());
                }catch (ParseException e){
                        System.out.println (e.getMessage ());
                }
        }
        if (contracts.getContract_date ().equals ("")){
            errors.rejectValue ("beginDate","date.inValid");
        }else {
            try {
                beginDate = new SimpleDateFormat ("dd/MM/yyyy").parse (contracts.getContract_date ());
            }catch (ParseException e){
                System.out.println (e.getMessage ());
            }
        }
        if (contracts.getDeposit ()<0){
                errors.rejectValue ("deposit","deposit.negative");
        }
        if (contracts.getTotal ()<0){
                errors.rejectValue ("total","total.negative");
        }
        if (beginDate != null && endDate != null){
                if (beginDate.after (endDate)){
                        errors.rejectValue ("beginDate","date.order");
                }
        }
    }
}
