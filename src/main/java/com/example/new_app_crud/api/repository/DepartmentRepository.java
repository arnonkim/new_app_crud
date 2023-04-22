package com.example.new_app_crud.api.repository;

import com.example.new_app_crud.api.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
