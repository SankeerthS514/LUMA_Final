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
import com.grp5.bootcamp4.entity.User;
import com.grp5.bootcamp4.exceptions.EmployeeDoesNotExistException;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
    	return userService.getUserById(userId);
	}
    

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) throws RecordAlreadyExistsException,EmployeeDoesNotExistException{
    	return userService.createUser(user);
        
    }
    
    @PutMapping("/forget/{id}")
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long userId,
        @Valid @RequestBody User userDetails) throws ServiceNotFoundException {
        return userService.updateUser(userId, userDetails);
    }
    
    @DeleteMapping("/user/{id}")
    public Map < String, Boolean > deleteUser(@PathVariable(value = "id") Long userId)
    {
    

       return userService.deleteUser(userId);
    }
    
    @CrossOrigin
    @PostMapping("/login")
    public String validateLogin(@RequestBody User user)

    {
    	return userService.validateLogin(user);
    			
    }
}
