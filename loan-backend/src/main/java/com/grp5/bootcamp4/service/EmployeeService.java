package com.grp5.bootcamp4.service;

import java.util.List;

import com.grp5.bootcamp4.entity.Employee;



import java.util.*;

import javax.management.ServiceNotFoundException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import com.grp5.bootcamp4.repo.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

   //Service to get all employees
    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }

    //Service to get an employee based on ID
    public Employee getEmployeeById(Long employeeId) {
    	return employeeRepository.findById(employeeId).get();
	}
    

   //Service to create an employee
    public Employee createEmployee(Employee employee) throws RecordAlreadyExistsException {
    	
    	//Check if employee already exists
    	if(employeeRepository.existsById(employee.getId()))
    	{
    		throw new RecordAlreadyExistsException("This User Already Exists");
    	} 
        return employeeRepository.save(employee);
    }
   
    //Service to update employee
    public ResponseEntity < Employee > updateEmployee(Long employeeId,
        @Valid @RequestBody Employee employeeDetails) throws ServiceNotFoundException {
    	   
    		//Get employee object based on ID
    		Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setdeparment(employeeDetails.getdeparment());
            employee.setdob(employeeDetails.getdob());
            employee.setdesignation(employeeDetails.getdesignation());
            
            employee.setdoj(employeeDetails.getdoj());

            employee.setEmailId(employeeDetails.getEmailId());
        
            final Employee updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
    }

    //Service to delete an employee
    public Map < String, Boolean > deleteEmployee(Long employeeId)
    {
    

        employeeRepository.deleteById(employeeId);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


