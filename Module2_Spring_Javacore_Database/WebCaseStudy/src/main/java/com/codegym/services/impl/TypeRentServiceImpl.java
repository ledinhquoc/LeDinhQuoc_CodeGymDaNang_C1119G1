package com.codegym.services.impl;

import com.codegym.entity.TypeRent.TypeRent;
import com.codegym.repository.RentTypeRipository;
import com.codegym.services.TypeRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TypeRentServiceImpl implements TypeRentService {
    @Autowired
    RentTypeRipository rentTypeRipository;

    @Override
    public Iterable<TypeRent> findAll() {
        return rentTypeRipository.findAll();
    }
}
