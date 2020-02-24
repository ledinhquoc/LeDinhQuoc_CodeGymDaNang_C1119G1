package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import org.springframework.stereotype.Service;


public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}
