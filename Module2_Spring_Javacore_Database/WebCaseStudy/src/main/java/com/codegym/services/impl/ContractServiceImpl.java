package com.codegym.services.impl;

import com.codegym.entity.Contracts.Contracts;
import com.codegym.repository.ContractRepository;
import com.codegym.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contracts> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contracts findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contracts contracts) {
        contractRepository.save(contracts);
    }

    @Override
    public void remove(Long id) {
            contractRepository.deleteById(id);
    }
}
