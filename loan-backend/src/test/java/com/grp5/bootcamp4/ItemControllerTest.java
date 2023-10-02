package com.grp5.bootcamp4;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.grp5.bootcamp4.controller.ItemController;
import com.grp5.bootcamp4.entity.Item;
import com.grp5.bootcamp4.exceptions.CustomErrorMessage;
import com.grp5.bootcamp4.service.ItemService;

@SpringBootTest
class ItemControllerTest {

	@MockBean
	private ItemService itemService;
	
	@Autowired
	private ItemController itemController;
	
	
	@Test
	public void getItemsTest() {
		
		Mockito.when(itemService.getAllItem()).thenReturn(List.of(new Item("Furniture","Chair","Wooden",11,"Available")));
		Assert.assertEquals(1,itemController.getAllItem().size());
	}
	
	@Test
	public void getItemByIdTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		Item returnItem  = new Item("Furniture","Chair","Wooden",11,"Available");
		returnItem.setId(1);
		Mockito.when(itemService.getItemById(id2)).thenReturn(
				returnItem);
		Assert.assertEquals(1,itemController.getItemById(id2).getId());
	}
	
	@Test
	public void getItemByIdErrorTest() throws CustomErrorMessage {
		int id = 1;
		long id2 = id;
		Item returnItem  = new Item("Furniture","Chair","Wooden",11,"Available");
		returnItem.setId(1);
		
		Mockito.when(itemService.getItemById(id2)).thenThrow(new CustomErrorMessage("ID does not Exist"));
	    Assert.assertThrows(CustomErrorMessage.class,() ->{
	    	itemController.getItemById(id2);
	    });
	    
	}
	
	@Test
	public void createItemTest() {
		Item returnItem  = new Item("Furniture","Chair","Wooden",11,"Available");
		Item TestItem  = new Item("Furniture","Chair","Wooden",11,"Available");
		returnItem.setId(1);
		Mockito.when(itemService.createItem(Mockito.any(Item.class))).thenReturn(returnItem);
		Assert.assertEquals(returnItem,itemController.createItem(TestItem));
	}
	
	
	
	
	@Test
	void contextLoads() {
	}

}
