package com.grp5.bootcamp4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.repo.EmployeeRepository;
import com.grp5.bootcamp4.repo.IssuedRepository;
import com.grp5.bootcamp4.repo.ItemRepository;

@Service
public class IssuedService {
    @Autowired
    private IssuedRepository issuedRepository;
    @Autowired
    private ItemRepository itemRepository; 

   //Service to get all issued items
    public List < Issued > getAllIssued() {
        return issuedRepository.findAll();
    }
    
    //Service to get all issued items for a specific User
    public List<Item> getIssuedByempId(Long empid){
    	
    	List <Issued> Items = issuedRepository.findAllByempid(empid);
    	List <Item> IssuedItems = new ArrayList<Item>();
    	for(Issued item:Items) {
    		IssuedItems.add(itemRepository.findById(item.getitemid()).get());
    	}
    	return IssuedItems;
    }	

    //Service to get a specific issued item based on Issued ID
    public Issued getIssuedById(Long IssuedId) {
    	return issuedRepository.findById(IssuedId).get();
	}
}
