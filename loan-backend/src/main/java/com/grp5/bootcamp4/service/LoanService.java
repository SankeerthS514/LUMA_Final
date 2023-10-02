package com.grp5.bootcamp4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.entity.Master;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.repo.LoanRepository;
import com.grp5.bootcamp4.repo.MasterRepository;

import jakarta.validation.Valid;

@Service
public class LoanService {
	
	@Autowired
    private LoanRepository loanRepository;
	@Autowired
	private MasterRepository masterRepository;
	@Autowired
	private MasterService masterService;
    
	//Service to get all Loan Cards
	public List < Loan > getAllLoan() {
        return loanRepository.findAll();
    }

	//Service to get a Loan card based on loan ID
    public Loan getLoanById(@PathVariable(value = "id") Long loanId) throws CustomErrorMessage {
    	if(!loanRepository.existsById(loanId)) {
    		throw new CustomErrorMessage("ID does not exist");
    	}
    	return loanRepository.findById(loanId).get();
    	
	}
    
    //Service to get all active loan cards for a specific user
	public List < Loan > getAllActiveLoan(Long empid) throws CustomErrorMessage {
		List<Master> allLoan = masterService.getApprovedMasterId(empid);
		List<Loan> allActiveLoan = new ArrayList<Loan>();
    	for(Master loan:allLoan) {
    		allActiveLoan.add(loanRepository.findById(loan.getId()).get());
    	}
    	return allActiveLoan;
	}
	
	//Service to update a loan card
	public ResponseEntity < Loan > updateLoan(Long loanId, Loan loanDetails) throws ConfigDataResourceNotFoundException {
	        Loan loan = loanRepository.findById(loanId).get();
	            

	        loan.setloan_type(loanDetails.getloan_type());
	        loan.setduration_in_years(loanDetails.getduration_in_years());
	        loan.setStatus(loanDetails.getStatus());
	        final Loan updatedLoan = loanRepository.save(loan);
	        return ResponseEntity.ok(updatedLoan);
	    }
	
	
	
}
