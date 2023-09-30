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
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.entity.Master;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.service.EmployeeService;
import com.grp5.bootcamp4.service.ItemService;
import com.grp5.bootcamp4.service.LoanService;
import com.grp5.bootcamp4.service.MasterService;


@CrossOrigin
@RestController
@RequestMapping("/api/v6")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public List < Item > getAllItem() {
        return itemService.getAllItem();
    }

//    @GetMapping("/loan/{id}")
//    public List<Master> getMasterId(@PathVariable(value = "id") Long masterId) {
//    	return masterService.getMasterId(masterId);
//	}
    @GetMapping("/item/{id}")
    public Item getItemById(Long id) {
    	
    	return  itemService.getItemById(id);
	}

    @PostMapping("/item")
    public Item createItem(@Valid @RequestBody Item item){
    	
        return itemService.createItem(item);
    }
//    @PutMapping("/employees/{id}")
//    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
//        @Valid @RequestBody Employee employeeDetails) throws ServiceNotFoundException {
//        
//        return employeeService.updateEmployee(employeeId, employeeDetails);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
//    {
//       return employeeService.deleteEmployee(employeeId); 
//    }
}