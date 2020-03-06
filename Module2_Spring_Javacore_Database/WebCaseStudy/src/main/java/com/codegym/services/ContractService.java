package com.codegym.services;

import com.codegym.entity.Contracts.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContractService {
    Page<Contracts> findAll(Pageable pageable);
    Contracts findById(Long id);

    void save(Contracts contracts);
    void remove(Long id);
}
