package com.grp5.bootcamp4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.ServiceNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.grp5.bootcamp4.controller.LoanMasterController;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.entity.Master;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.exceptions.ItemIsNotAvailableException;
import com.grp5.bootcamp4.exceptions.RecordAlreadyExistsException;
import com.grp5.bootcamp4.service.MasterService;

@SpringBootTest
class MasterControllerTest {

	@MockBean
	private MasterService masterService;
	
	@Autowired
	private LoanMasterController masterController;
	
	
	@Test
	public void getAllMastersTest() {
		List<Master> Loan = new ArrayList<Master>();
		Loan.add(new Master(1,"Furniture","Steel","Table","Approved",1));
		Loan.add(new Master(1,"Furniture","Wooden","Table","Approved",1));
		
		Mockito.when(masterService.getAllMaster()).thenReturn(Loan);
		Assert.assertEquals(2,masterController.getAllMaster().size());
	}
	
	@Test
	public void getMasterByIdTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		List<Master> Loan = new ArrayList<Master>();
		Loan.add(new Master(1,"Furniture","Steel","Table","Approved",1));
		Loan.add(new Master(1,"Furniture","Wooden","Table","Approved",1));
		Mockito.when(masterService.getMasterId(id2)).thenReturn(
				Loan);
		Assert.assertEquals(2,masterController.getMasterId(id2).size());
	}
	
	@Test
	public void getMasterByIdErrorTest() throws CustomErrorMessage {
		int id = 2;
		long id2 = id;
		Master returnMaster  = new Master(1,"Furniture","Steel","Table","Approved",1);
		
		
		Mockito.when(masterService.getMasterId(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
	    Assert.assertThrows(CustomErrorMessage.class,() ->{
	    	masterController.getMasterId(id2);
	    });
	    
	}
	
	@Test
	public void getApprovedMasterIdTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		List<Master> Loan = new ArrayList<Master>();
		Loan.add(new Master(1,"Furniture","Steel","Table","Approved",1));
		Loan.add(new Master(1,"Furniture","Wooden","Table","Approved",1));
		Mockito.when(masterService.getApprovedMasterId(id2)).thenReturn(
				Loan);
		Assert.assertEquals(2,masterController.getApprovedMasterId(id2).size());
	}
	
	@Test
	public void getApprovedMasterIdErrorTest() throws CustomErrorMessage {
		int id = 2;
		long id2 = id;
		Master returnMaster  = new Master(1,"Furniture","Steel","Table","Approved",1);
		
		
		Mockito.when(masterService.getApprovedMasterId(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
	    Assert.assertThrows(CustomErrorMessage.class,() ->{
	    	masterController.getApprovedMasterId(id2);
	    });
	    
	}
	
	public void createMasterTest() throws RecordAlreadyExistsException, ItemIsNotAvailableException{
		Master returnLoan  =  new Master(1,"Furniture","Steel","Table","Approved",1);
		Master TestLoan  =  new Master(1,"Furniture","Steel","Table","Approved",1);
		returnLoan.setId(1);
		Mockito.when(masterService.createMaster(Mockito.any(Master.class))).thenReturn(returnLoan);
		Assert.assertEquals(returnLoan,masterController.createMaster(TestLoan));
	}
	
	public void updateMasterTest() throws ServiceNotFoundException, CustomErrorMessage{
		Master returnLoan  =  new Master(1,"Furniture","Steel","Table","Approved",1);
		Master TestLoan  =  new Master(1,"Furniture","Steel","Table","Approved",1);
		returnLoan.setId(1);
		int id = 1;
		long id2 = id;
		Mockito.when(masterService.updateMaster(id2,TestLoan)).thenReturn(returnLoan);
		Assert.assertEquals(returnLoan,masterController.updateMaster(id2,TestLoan));
	}
	
//	public void updateMasterTest() {
//		Master returnLoan  =  new Master(1,"Furniture","Steel","Table","Approved",1);
//		Master TestLoan  =  new Master(1,"Furniture","Wooden","Table","Approved",1);
//		returnLoan.setId(1);
//		int id = 1;
//		long id2 = id;
//		Mockito.when(masterService.updateMaster(id2,TestLoan)).thenReturn(returnLoan);
//		Assert.assertEquals(returnLoan,masterController.updateMaster(TestLoan));
//	}
//	
//	@Test
//	public void getAllActiveMasterTest() throws CustomErrorMessage {
//		int id = 1;
//		long id2 = id;
//		List<Master> Loan = new ArrayList<Master>();
//		Loan.add(new Master(1,"Furniture",11,"Approved"));
//		Loan.add(new Master(1,"Furniture",12,"Approved"));
//		Mockito.when(masterService.getAllActiveMaster(id2)).thenReturn(
//				Loan);
//		Assert.assertEquals(2,masterController.getApprovedMasterById(id2).size());
//	}
//	
//	@Test
//	public void getAllActiveMasterErrorTest() throws CustomErrorMessage {
//		int id = 2;
//		long id2 = id;
//		Master returnMaster  = new Master(1,"Furniture",11,"Approved");
//		
//		
//		Mockito.when(masterService.getAllActiveMaster(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
//	    Assert.assertThrows(CustomErrorMessage.class,() ->{
//	    	masterController.getApprovedMasterById(id2);
//	    });
//	    
//	}
	
	
	
	
	@Test
	void contextLoads() {
	}

}
