package com.codegym.repository;

import com.codegym.entity.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRipository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer c where c.fullName like %?1%")
    Page<Customer> findAllWhereNameBeLike(String name, Pageable pageable);

    @Query("select c from Customer c inner join Contracts ct on c.customer_id = ct.contract_id")
    Page<Customer>findCustomerUsedService(Pageable pageable);
}
