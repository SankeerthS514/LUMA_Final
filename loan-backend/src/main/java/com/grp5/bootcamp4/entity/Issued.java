package com.grp5.bootcamp4.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "issued")
public class Issued {

    private long id;
    private long empid;
    private long loanid;
    private long itemid;
    private Date issuedate;
    
    
   
    



	public Issued() {
    	
    }

    public Issued(long loanid,long itemid,long empid,Date issuedate ) {
        
    	this.loanid = loanid;
        this.itemid=itemid;
        this.empid=empid;
        this.issuedate=issuedate;
        
        
        
       
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

  

    
  
    
public long getempid() {
	return empid;
}

public void setempid(long empid) {
	this.empid = empid;
}

public long getitemid() {
	return itemid;
}

public void setitemid(long itemid) {
	this.itemid = itemid;
}


public Date getissuedate() {
	return issuedate;
}

public void setissuedate(Date issuedate) {
	this.issuedate = issuedate;
}

public long getLoanid() {
	return loanid;
}

public void setLoanid(long loanid) {
	this.loanid = loanid;
}




	

    
}
