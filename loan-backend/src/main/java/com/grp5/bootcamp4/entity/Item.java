package com.grp5.bootcamp4.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    private long id;
    private String itemcat;
    
    private String itemmake;
    private String itemdesc;
   
    private long itemvalue;
    
    private String status;
   
    



	public Item() {
    	
    }

    public Item(String itemcat, String itemmake, String itemdesc, long itemvalue, String status) {
        
        this.itemcat=itemcat;
        this.itemmake=itemmake;
        this.itemdesc=itemdesc;
        this.itemvalue=itemvalue;
        
        this.status=status;
       
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

  

    
   
    
    public String getItemcat() {
	return itemcat;
}

public void setItemcat(String itemcat) {
	this.itemcat = itemcat;
}

public String getItemmake() {
	return itemmake;
}

public void setItemmake(String itemmake) {
	this.itemmake = itemmake;
}


public String getItemdesc() {
	return itemdesc;
}

public void setItemdesc(String itemdesc) {
	this.itemdesc = itemdesc;
}


public long getItemvalue() {
	return itemvalue;
}

public void setItemvalue(long itemvalue) {
	this.itemvalue = itemvalue;
}




public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	

    
}
