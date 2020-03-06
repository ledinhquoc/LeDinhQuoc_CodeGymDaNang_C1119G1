package com.codegym.services.impl;

import com.codegym.entity.TypeCustomer.TypeCustomers;
import com.codegym.repository.TypeCustomerRepository;
import com.codegym.services.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {
    @Autowired
    TypeCustomerRepository typeCustomerRepository;

    @Override
    public Iterable<TypeCustomers> findAll() {
        return typeCustomerRepository.findAll();
    }
}
