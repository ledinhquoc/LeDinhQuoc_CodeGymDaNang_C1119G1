package com.codegym.services;

import com.codegym.entity.Services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
Page<Services>findAll(Pageable pageable);
Page<Services>findAllWhereNameBeLike(String name,Pageable pageable);
Services findById(Long id);
Page<Services> findAllByStatus(String status,Pageable pageable);

void save(Services services);
void remove(Long id);

}
