package com.codegym.services.impl;

import com.codegym.entity.TypeServices.TypeService;
import com.codegym.repository.TypeServiceRepository;
import com.codegym.services.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TypeServiceServiceImpl implements TypeServiceService {
    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Override
    public Iterable<TypeService> findAll() {
        return typeServiceRepository.findAll();
    }
}
