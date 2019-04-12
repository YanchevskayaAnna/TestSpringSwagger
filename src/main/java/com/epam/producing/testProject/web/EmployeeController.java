package com.epam.producing.testProject.web;

import com.epam.producing.testProject.exceptions.employeeExceptions.EmployeeNotFoundException;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    @ApiOperation(value = "get all employees")
    List<Employee> all() {return repository.findAll();}

    @PostMapping
    @ApiOperation(value = "create new employee")
    ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(repository.save(newEmployee), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get information about employee by id")
    Employee one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }



}
