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

import com.grp5.bootcamp4.controller.IssuedController;
import com.grp5.bootcamp4.controller.ItemController;
import com.grp5.bootcamp4.entity.Issued;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.service.IssuedService;
import com.grp5.bootcamp4.service.ItemService;

@SpringBootTest
class IssuedControllerTest {

	@MockBean
	private IssuedService issuedService;
	
	@Autowired
	private IssuedController issuedController;
	
	
	@Test
	public void getIssuedTest() {
		List<Issued> IssuedItems = new ArrayList<Issued>();
		IssuedItems.add(new Issued(1,1,1,new Date()));
		IssuedItems.add(new Issued(2,2,2,new Date()));
		Mockito.when(issuedService.getAllIssued()).thenReturn(IssuedItems);
		Assert.assertEquals(2,issuedController.getAllIssued().size());
	}
	
	@Test
	public void getIssuedByIdTest(){
		int id = 1;
		long id2 = id;
		Issued returnItem  = new Issued(1,1,1,new Date());
		returnItem.setId(1);
		Mockito.when(issuedService.getIssuedById(id2)).thenReturn(
				returnItem);
		Assert.assertEquals(1,issuedController.getissuedById(id2).getId());
	}
	
	@Test
	public void getIssuedByEmpIdTest(){
		int id = 1;
		long id2 = id;
		List<Item> IssuedItems = new ArrayList<Item>();
		IssuedItems.add(new Item("Furniture","Chair","Wooden",11,"Available"));
		IssuedItems.add(new Item("Furniture","Chair","Wooden",11,"Available"));
		Mockito.when(issuedService.getIssuedByempId(id2)).thenReturn(
				IssuedItems);
		Assert.assertEquals(2,issuedController.getIssuedByempId(id2).size());
	}
	
//	@Test
//	public void getItemByIdErrorTest() throws CustomErrorMessage {
//		int id = 1;
//		long id2 = id;
//		Item returnItem  = new Item("Furniture","Chair","Wooden",11,"Available");
//		returnItem.setId(1);
//		
//		Mockito.when(itemService.getItemById(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
//	    Assert.assertThrows(CustomErrorMessage.class,() ->{
//	    	itemController.getItemById(id2);
//	    });
//	    
//	}
//	
//	@Test
//	public void createItemTest() {
//		Item returnItem  = new Item("Furniture","Chair","Wooden",11,"Available");
//		Item TestItem  = new Item("Furniture","Chair","Wooden",11,"Available");
//		returnItem.setId(1);
//		Mockito.when(itemService.createItem(Mockito.any(Item.class))).thenReturn(returnItem);
//		Assert.assertEquals(returnItem,itemController.createItem(TestItem));
//	}
//	
	
	
	
	@Test
	void contextLoads() {
	}

}
