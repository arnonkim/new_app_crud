package com.example.new_app_crud.api.controller;

import com.example.new_app_crud.api.entities.Department;
import com.example.new_app_crud.api.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            summary = "Get all departments",
            description = "Get all departments"
    )
    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @Operation(
            summary = "Add new department",
            description = "Add new department"
    )
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Department department) {
        Department departmentSaved = departmentService.save(department);
        return new ResponseEntity<>(departmentSaved, HttpStatus.OK);
    }

    @Operation(
            summary = "Get department by id",
            description = "Get department by id"
    )
    @GetMapping("/{departmentId}")
    public ResponseEntity<Object> getById(@PathVariable Long departmentId) {
        Department department = departmentService.findById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @Operation(
            summary = "Update department",
            description = "Update department"
    )
    @PutMapping("/{departmentId}")
    public ResponseEntity<Object> update(@PathVariable Long departmentId, @RequestBody Department department) {
        department.setId(departmentId);
        Department departmentSaved = departmentService.save(department);
        return new ResponseEntity<>(departmentSaved, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete department",
            description = "Delete department"
    )
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Object> delete(@PathVariable Long departmentId) {
        departmentService.deleteById(departmentId);
        return new ResponseEntity<>("Department is deleted", HttpStatus.OK);
    }

}
