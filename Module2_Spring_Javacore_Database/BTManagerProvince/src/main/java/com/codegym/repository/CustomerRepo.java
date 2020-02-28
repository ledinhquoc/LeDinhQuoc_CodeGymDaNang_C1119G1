package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
}
