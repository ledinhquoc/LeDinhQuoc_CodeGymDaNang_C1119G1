package com.codegym.repository;

import com.codegym.entity.TypeCustomer.TypeCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeCustomerRepository extends JpaRepository<TypeCustomers,Long> {
@Query("select tc from TypeCustomers tc")
    List<TypeCustomers> getAll();
}
