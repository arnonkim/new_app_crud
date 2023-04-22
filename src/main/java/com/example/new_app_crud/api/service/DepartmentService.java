package com.example.new_app_crud.api.service;

import com.example.new_app_crud.api.entities.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findById(Long id);

    Department save(Department department);

    void deleteById(Long id);

}
