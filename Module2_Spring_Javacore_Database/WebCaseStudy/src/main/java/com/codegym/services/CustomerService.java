package com.codegym.services;

import com.codegym.entity.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void remove(Long id);
    List<Customer>findAll();
    Page<Customer>findAll(Pageable pageable);
    Page<Customer>findAllWhereNameBeLike(String name, Pageable pageable);
    Page<Customer>findCustomerUsedService(Pageable pageable);
    Customer findById(Long id);
}
