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
import com.grp5.bootcamp4.entity.Master;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.exceptions.ItemIsNotAvailableException;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.service.EmployeeService;
import com.grp5.bootcamp4.service.LoanService;
import com.grp5.bootcamp4.service.MasterService;


@CrossOrigin
@RestController
@RequestMapping("/api/v5")
public class LoanMasterController {
    @Autowired
    private MasterService masterService;

    //Get mapping to get all loans
    @GetMapping("/loan")
    public List < Master > getAllMaster() {
        return masterService.getAllMaster();
    }
    
    //Get mapping to get all loans based on loan ID
    @GetMapping("/loan/{id}")
    public List<Master> getMasterId(@PathVariable(value = "id") Long empid) throws CustomErrorMessage{
    	return masterService.getMasterId(empid);
	}
    
    //Get mapping to get all approved loans based on Employee ID
    @GetMapping("/loan/approved/{id}")
    public List<Master> getApprovedMasterId(@PathVariable(value = "id") Long empid) throws CustomErrorMessage {
    	return masterService.getApprovedMasterId(empid);
	}
    
    //Post mapping to create a loan
    @PostMapping("/loan")
    public Master createMaster(@Valid @RequestBody Master master) throws RecordAlreadyExistsException,ItemIsNotAvailableException {
    	
        return masterService.createMaster(master);
    }
    
    //Put mapping to update a loan
    @PutMapping("/loan/{id}")
    public Master updateMaster(@PathVariable(value = "id") Long masterId,
        @Valid @RequestBody Master masterDetails) throws ServiceNotFoundException, CustomErrorMessage {
        
        return masterService.updateMaster(masterId, masterDetails);
    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
//    {
//       return employeeService.deleteEmployee(employeeId); 
//    }
}