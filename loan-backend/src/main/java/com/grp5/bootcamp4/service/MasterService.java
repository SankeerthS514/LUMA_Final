package com.grp5.bootcamp4.service;

import com.grp5.bootcamp4.entity.Employee;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.entity.Master;

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
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.exceptions.ItemIsNotAvailableException;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.repo.EmployeeRepository;
import com.grp5.bootcamp4.repo.IssuedRepository;
import com.grp5.bootcamp4.repo.ItemRepository;
import com.grp5.bootcamp4.repo.LoanRepository;
import com.grp5.bootcamp4.repo.MasterRepository;

@Service
public class MasterService {
    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private IssuedRepository issuedRepository;

   
    public List < Master > getAllMaster() {
        return masterRepository.findAll();
    }
    
    
    public List<Master> getMasterId(Long empid) {
    	
    	return  masterRepository.findAllByEmpid(empid);
	}

    public List<Master> getApprovedMasterId(Long empid) {
    	List<Master> allLoan = masterRepository.findAllByEmpid(empid);
    	List<Master> allActiveLoan = new ArrayList<Master>();
    	for(Master loan:allLoan) {
    		if(loan.getStatus().equals("Approved")) {
    			allActiveLoan.add(loan);
    		}
    	}
    	return allActiveLoan; 
	}
    
    public Master createMaster(Master master) throws RecordAlreadyExistsException, ItemIsNotAvailableException {
    	if(masterRepository.existsById(master.getId()))
    	{
    		throw new RecordAlreadyExistsException("This User Already Exists");
    	}
    	
    	List <Item> item = itemRepository.findByitemcatAndItemmakeAndItemdescAndStatus(master.getItem_cat(), master.getItem_make(), master.getItem_desc(),"Available");
    	if(item.isEmpty()) {
    		throw new ItemIsNotAvailableException("This Item Is Not Available");
    	}
    	Item issuedItem = item.get(0);
    	master.setItem_value(issuedItem.getItemvalue());
    	issuedItem.setStatus("Reserved");
    	itemRepository.save(issuedItem);
        return masterRepository.save(master);
    }
    public ResponseEntity < Master > updateMaster(Long masterId,
            @Valid @RequestBody Master masterDetails) throws ServiceNotFoundException,CustomErrorMessage {
        	    Master master = masterRepository.findById(masterId)
                    .orElseThrow();
        	    
        	    //System.out.println(!master.getStatus().equals("Pending"));
        	    
                // Switch case for changing state of the Loan by the admin
                switch(masterDetails.getStatus()) {
                case "Approved":
                	
                	//Make sure that the status can only be changed on pending loans
                  if(!master.getStatus().equals("Pending")) {
            	    	throw new CustomErrorMessage("Action has already been taken on your loan");
            	    }	
                  
                  master.setIssue_date(new Date());;
                  masterRepository.save(master);
                  //Create a loan card with the details fetched for this specific loan
                  Loan loancard = new Loan(masterId,master.getItem_cat(),master.getduration_in_years(), "Approved");
                  //Get the list of items for this loan and assign one, there will always be an item available 
                  //since the item is reserved on application based on availability
                  List <Item> item = itemRepository.findByitemcatAndItemmakeAndItemdescAndStatus(master.getItem_cat(), master.getItem_make(), master.getItem_desc(),"Reserved");
                  
                  Item issuedItem = item.get(0);
                  //Set the status of the item as issued so that it cannot be assigned to a different loan
                  issuedItem.setStatus("Issued");
              	  itemRepository.save(issuedItem);
              	  //Add the item to the issued table, along with the loan ID and the emp ID
              	  Issued issue = new Issued(masterId,issuedItem.getId(),master.getempid(),new Date());
              	  issuedRepository.save(issue);
                  loanRepository.save(loancard);
                  break;
                case "Closed":
                  //The loan can only be applied on loans that are of approved status
                  if(!master.getStatus().equals("Approved")) {
            	    	throw new CustomErrorMessage("Action has already been taken on your loan");
            	    }
                  //The issued item must be removed from the issued table and the loan must change status to closed
                  Issued closedIssue = issuedRepository.findByloanid(masterId);
                  Loan closedLoan = loanRepository.findById(masterId).get();
                  closedLoan.setStatus("Closed");
                  loanRepository.save(closedLoan);
                  //The item must get the available status as it is returned 
                  long ItemId = closedIssue.getitemid();
                  issuedRepository.deleteById(closedIssue.getId());
                  Item Returneditem = itemRepository.findById(ItemId).get();
                  Returneditem.setStatus("Available");
                  itemRepository.save(Returneditem);
                  break;
           
                	
                  
              }
                
                master.setStatus(masterDetails.getStatus());
                final Master updatedMaster = masterRepository.save(master);
                
                return ResponseEntity.ok(updatedMaster);
        }
}