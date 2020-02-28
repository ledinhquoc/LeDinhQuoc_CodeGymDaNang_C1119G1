package com.codegym.service;

import com.codegym.model.Province;

import java.util.Optional;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Integer id);

    void save(Province province);

    void remove(Integer id);
}
