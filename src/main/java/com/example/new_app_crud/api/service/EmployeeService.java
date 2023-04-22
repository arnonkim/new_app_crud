package com.example.new_app_crud.api.service;

import com.example.new_app_crud.api.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
