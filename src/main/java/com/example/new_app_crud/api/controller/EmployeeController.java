package com.example.new_app_crud.api.controller;

import com.example.new_app_crud.api.entities.Employee;
import com.example.new_app_crud.api.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(
            summary = "Get Employees",
            description = "API : get employees"
    )
    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(
            summary = "Create Employee",
            description = "API : create employee"
    )
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Employee employee) {
        Employee employeeSaved = employeeService.save(employee);
        return new ResponseEntity<>(employeeSaved, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Employee By ID",
            description = "API : Get Employee By ID"
    )
    @GetMapping("/{employeeId}")
    public ResponseEntity<Object> getById(@PathVariable Long employeeId) {

        Optional<Employee> employeeOpt = employeeService.findById(employeeId);
        if (employeeOpt.isPresent()) {
            return new ResponseEntity<>(employeeOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee is not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Update Employee By ID",
            description = "API : Update Employee By ID"
    )
    @PutMapping("/{employeeId}")
    public ResponseEntity<Object> update(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Optional<Employee> employeeOpt = employeeService.findById(employeeId);
        if (employeeOpt.isPresent()) {
            employee.setId(employeeId);
            Employee employeeSaved = employeeService.save(employee);
            return new ResponseEntity<>(employeeSaved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee is not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Delete Employee By ID",
            description = "API : Delete Employee By ID"
    )
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> delete(@PathVariable Long employeeId) {
        Optional<Employee> employeeOpt = employeeService.findById(employeeId);
        if (employeeOpt.isPresent()) {
            employeeService.deleteById(employeeId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee is not found", HttpStatus.NOT_FOUND);
        }
    }

}
