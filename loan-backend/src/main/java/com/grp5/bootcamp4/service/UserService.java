package com.grp5.bootcamp4.service;

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
import com.grp5.bootcamp4.repo.EmployeeRepository;
import com.grp5.bootcamp4.repo.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    
    public User getUserById(Long userId) {
    	return userRepository.findById(userId).get();
	}
    

    
    public User createUser(User user) throws RecordAlreadyExistsException, EmployeeDoesNotExistException{
    	if(userRepository.existsById(user.getId()))
    	{
    		throw new RecordAlreadyExistsException("This User Already Exists");
    	} 
    	if(!employeeRepository.existsById(user.getId())) {
    		throw new EmployeeDoesNotExistException("This ID is not linked to an existing employee");
    	}
        return userRepository.save(user);
        
    }
    
    public ResponseEntity updateUser(Long userId, User userDetails) throws ServiceNotFoundException {
 
            User user = userRepository.findById(userId)
                .orElseThrow();

            user.setpassword(userDetails.getpassword());
            
        
            final User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
    }
    

    public Map < String, Boolean > deleteUser(@PathVariable(value = "id") Long userId)
    {
    

        userRepository.deleteById(userId);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    public String validateLogin(User user)

    {
    	if(!userRepository.existsById(user.getId()))
    	{
    		return "FailUser";
    	}
    	User tempUser=userRepository.getReferenceById(user.getId());
    	if(tempUser.getpassword().equals(user.getpassword()))
    			{
    		return "sucess";
    			}
    	else {
    		return "FailPass";
    	}
    }
}


