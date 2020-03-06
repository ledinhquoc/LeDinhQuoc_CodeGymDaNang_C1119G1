package com.codegym.services.impl;

import com.codegym.entity.Services.Services;
import com.codegym.repository.ServiceRepository;
import com.codegym.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Services> findAllWhereNameBeLike(String name, Pageable pageable) {
        return serviceRepository.findAllWhereNameBeLike(name,pageable);
    }

    @Override
    public Services findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page< Services > findAllByStatus(String status, Pageable pageable) {
        return serviceRepository.findAllByStatus (status,pageable);
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public void remove(Long id) {
            serviceRepository.deleteById(id);
    }
}
