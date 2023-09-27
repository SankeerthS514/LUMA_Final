package com.grp5.bootcamp4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.service.EmployeeService;
import com.grp5.bootcamp4.service.IssuedService;

@CrossOrigin
@RestController
@RequestMapping("/api/v4")
public class IssuedController {
	@Autowired
    private IssuedService issuedService;
	
	@GetMapping("/issued")
    public List < Issued > getAllIssued() {
        return issuedService.getAllIssued();
    }

    @GetMapping("/issued/{id}")
    public Issued getissuedById(@PathVariable(value = "id") Long issuedId) {
    	return issuedService.getIssuedById(issuedId);
	}
    
    @GetMapping("/issued/items/{id}")
    public List<Item> getIssuedByempId(@PathVariable(value = "id") Long empid){
    	return issuedService.getIssuedByempId(empid);
    }
}
