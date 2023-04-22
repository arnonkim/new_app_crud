package com.example.new_app_crud.api.service.impl;

import com.example.new_app_crud.api.entities.Department;
import com.example.new_app_crud.api.repository.DepartmentRepository;
import com.example.new_app_crud.api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepo.findById(id).get();
    }

    @Override
    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepo.deleteById(id);
    }
}