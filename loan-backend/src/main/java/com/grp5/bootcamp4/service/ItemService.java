package com.grp5.bootcamp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.entity.Master;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.repo.EmployeeRepository;
import com.grp5.bootcamp4.repo.ItemRepository;
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item getItemById(Long id) {
    	
    	return  itemRepository.findById(id).get();
	}
	
	  public Item createItem(Item item){
		  
	        return itemRepository.save(item);
	    }

}
