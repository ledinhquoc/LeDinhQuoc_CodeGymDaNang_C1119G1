package com.codegym.repository;

import com.codegym.entity.Employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where e.fullName like %?1%")
    Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable);

    @Query("select e from Employee e inner join Contracts ct on ct.employee_id = e.employee_id")
    Page<Employee>findAllEmployeeHavingContract(Pageable pageable);

}
