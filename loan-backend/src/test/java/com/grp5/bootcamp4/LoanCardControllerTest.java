package com.grp5.bootcamp4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.grp5.bootcamp4.controller.LoanController;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Loan;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.service.LoanService;

@SpringBootTest
class LoanCardControllerTest {

	@MockBean
	private LoanService loanService;
	
	@Autowired
	private LoanController loanController;
	
	
	@Test
	public void getLoansTest() {
		List<Loan> LoanCards = new ArrayList<Loan>();
		LoanCards.add(new Loan(1,"Furniture",11,"Approved"));
		LoanCards.add(new Loan(1,"Furniture",12,"Approved"));
		
		Mockito.when(loanService.getAllLoan()).thenReturn(LoanCards);
		Assert.assertEquals(2,loanController.getAllLoan().size());
	}
	
	@Test
	public void getLoanByIdTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		Loan returnLoan  = new Loan(1,"Furniture",11,"Approved");
		Mockito.when(loanService.getLoanById(id2)).thenReturn(
				returnLoan);
		Assert.assertEquals(1,loanController.getLoanById(id2).getId());
	}
	
	@Test
	public void getLoanByIdErrorTest() throws CustomErrorMessage {
		int id = 2;
		long id2 = id;
		Loan returnLoan  = new Loan(1,"Furniture",11,"Approved");
		
		
		Mockito.when(loanService.getLoanById(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
	    Assert.assertThrows(CustomErrorMessage.class,() ->{
	    	loanController.getLoanById(id2);
	    });
	    
	}
	
	@Test
	public void getAllActiveLoanTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		List<Loan> LoanCards = new ArrayList<Loan>();
		LoanCards.add(new Loan(1,"Furniture",11,"Approved"));
		LoanCards.add(new Loan(1,"Furniture",12,"Approved"));
		Mockito.when(loanService.getAllActiveLoan(id2)).thenReturn(
				LoanCards);
		Assert.assertEquals(2,loanController.getApprovedLoanById(id2).size());
	}
	
	@Test
	public void getAllActiveLoanErrorTest() throws CustomErrorMessage {
		int id = 2;
		long id2 = id;
		Loan returnLoan  = new Loan(1,"Furniture",11,"Approved");
		
		
		Mockito.when(loanService.getAllActiveLoan(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
	    Assert.assertThrows(CustomErrorMessage.class,() ->{
	    	loanController.getApprovedLoanById(id2);
	    });
	    
	}
	
	
	
	
	@Test
	void contextLoads() {
	}

}
