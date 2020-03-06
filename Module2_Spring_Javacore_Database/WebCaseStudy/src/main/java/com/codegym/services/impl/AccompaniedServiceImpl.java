package com.codegym.services.impl;

import com.codegym.entity.AccompaniedServices.AccompaniedServices;
import com.codegym.repository.AccompaniedServiceRepository;
import com.codegym.services.AccompaniedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccompaniedServiceImpl implements AccompaniedService {
    @Autowired
    AccompaniedServiceRepository accompaniedServiceRepository;

    @Override
    public Iterable<AccompaniedServices> findAll() {
        return accompaniedServiceRepository.findAll();
    }
}
