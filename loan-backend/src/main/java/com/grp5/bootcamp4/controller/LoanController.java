
package com.grp5.bootcamp4.controller;

import java.util.*;

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

import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.repo.LoanRepository;
import com.grp5.bootcamp4.service.LoanService;

@RestController
@RequestMapping("/api/v2")
public class LoanController{
    @Autowired
    private LoanService loanService;

    @GetMapping("/loan")
    public List < Loan > getAllLoan() {
        return loanService.getAllLoan();
    }

    @GetMapping("/loan/{id}")
    public Loan getLoanById(@PathVariable(value = "id") Long loanId) {
    	return loanService.getLoanById(loanId);
    	
	}
    
    @GetMapping("/loan/approved/{id}")
    public List<Loan> getApprovedLoanById(@PathVariable(value = "id") Long empid) {
    	return loanService.getAllActiveLoan(empid);
    
	}
    

//    @PostMapping("/loan")
//    public Loan createLoan(@Valid @RequestBody Loan loan) {
//        return loanRepository.save(loan);
//    }
    @PutMapping("/loan/{id}")
    public ResponseEntity < Loan > updateLoan(@PathVariable(value = "id") Long loanId,
        @Valid @RequestBody Loan loanDetails) throws ConfigDataResourceNotFoundException {
        return loanService.updateLoan(loanId, loanDetails);
    }

//    @DeleteMapping("/loans/{id}")
//    public Map < String, Boolean > deleteLoan(@PathVariable(value = "id") Long loanId)
//    
//
//        loanRepository.delete(loan);
//        Map < String, Boolean > response = new HashMap < > ();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}

