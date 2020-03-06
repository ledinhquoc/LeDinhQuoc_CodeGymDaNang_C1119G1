package com.codegym.services.impl;

import com.codegym.entity.Employee.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable) {
        return employeeRepository.findAllWhereNameBeLike(name,pageable);
    }

    @Override
    public Page<Employee> findAllEmployeeHavingContract(Pageable pageable) {
        return employeeRepository.findAllEmployeeHavingContract(pageable);
    }

    @Override
    public void save(Employee employee) {
            employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
            employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
