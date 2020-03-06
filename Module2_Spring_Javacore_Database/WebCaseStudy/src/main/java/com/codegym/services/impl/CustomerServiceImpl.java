package com.codegym.services.impl;

import com.codegym.entity.Customer.Customer;
import com.codegym.repository.CustomerRipository;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRipository customerRipository;

    @Override
    public void save(Customer customer) {
        customerRipository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRipository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRipository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRipository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllWhereNameBeLike(String name, Pageable pageable) {
        return customerRipository.findAllWhereNameBeLike(name,pageable);
    }

    @Override
    public Page<Customer> findCustomerUsedService(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }
}
