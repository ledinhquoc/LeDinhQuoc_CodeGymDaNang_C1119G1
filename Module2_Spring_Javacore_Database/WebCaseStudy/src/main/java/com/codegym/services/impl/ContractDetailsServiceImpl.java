package com.codegym.services.impl;

import com.codegym.entity.ContractDetails.ContractDetails;
import com.codegym.repository.ContractDetailsRepository;
import com.codegym.services.ContracDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContractDetailsServiceImpl implements ContracDetailsService{
    @Autowired
    ContractDetailsRepository contractDetailsRepository;

    @Override
    public void saveContractDetails(ContractDetails contractDetails) {
        contractDetailsRepository.save(contractDetails);
    }
}
