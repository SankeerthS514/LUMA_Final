package com.grp5.bootcamp4.controller;

import java.util.*;

import javax.management.ServiceNotFoundException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //Get all the employees
    @GetMapping("/employees")
    public List < Employee > getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    //Get a specific employee based on employee ID
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) {
    	return employeeService.getEmployeeById(employeeId);
	}
    
    //Post mapping for creating an employee
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) throws RecordAlreadyExistsException {
    	
        return employeeService.createEmployee(employee);
    }
    
    //Update mapping for updating a specific employee based on ID
    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
        @Valid @RequestBody Employee employeeDetails) throws ServiceNotFoundException {
        
        return employeeService.updateEmployee(employeeId, employeeDetails);
    }

    //Delete mapping to remove an employee
    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
    {
       return employeeService.deleteEmployee(employeeId); 
    }
}
