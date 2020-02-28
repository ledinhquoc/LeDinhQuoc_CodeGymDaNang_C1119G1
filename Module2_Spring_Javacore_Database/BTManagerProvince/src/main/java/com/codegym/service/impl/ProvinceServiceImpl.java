package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepo;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepo provinceRepo;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return provinceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public void remove(Integer id) {
        provinceRepo.deleteById(id);
    }
}

