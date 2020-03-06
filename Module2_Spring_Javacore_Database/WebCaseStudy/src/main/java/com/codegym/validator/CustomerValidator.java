package com.codegym.validator;

import com.codegym.entity.Customer.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class< ? > aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer)o;
        final String email =customer.getEmail();
        final String phone_number = customer.getPhone_number();
        final String id_card = customer.getId_card();
        if (!email.matches("^[\\w]{1,3}[[\\d]*\\w]{6,9}@[\\w]{3,5}\\.[\\w]{3,5}$")){
        errors.rejectValue("email","email.inValid");
        }
        if (!phone_number.matches("^((091|090)[0-9]{7})|(\\(84\\)\\+(09|91)[0-9]{7})$")){
            errors.rejectValue("phone_number","phone_number.inValid");
        }
        if (!id_card.matches("^[\\d]{9}$")){
            errors.rejectValue("id_card","id_card.inValid");
        }
        if (customer.getBirthday().equals("")){
            errors.rejectValue("birthday","birthday.inValid");
        }

    }
}
