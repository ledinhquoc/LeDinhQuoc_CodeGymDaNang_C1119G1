package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    Iterable<Customer> findAllByProvince(Province province);
}
