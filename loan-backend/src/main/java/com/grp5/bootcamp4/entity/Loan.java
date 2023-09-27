package com.grp5.bootcamp4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_card_master")
public class Loan {

    private long id;
    private String loan_type;
    private int duration_in_years;
    private String Status;
   
    

    

	public Loan() {
    	
    }

    public Loan(long id, String loan_type,int duration_in_years, String Status) {
    	this.id = id;
        this.loan_type = loan_type;
        this.duration_in_years = duration_in_years;
        this.Status = Status;
        
    }

    @Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "loan_type", nullable = false)
    public String getloan_type() {
        return loan_type;
    }
    public void setloan_type(String loan_type) {
    	
    	 this.loan_type = loan_type;
    }

    @Column(name = "duration_in_years", nullable = false)
    public int getduration_in_years() {
        return duration_in_years;
    }
    public void setduration_in_years(int duration_in_years) {
        this.duration_in_years = duration_in_years;
    }
    
    public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
    

    
}

