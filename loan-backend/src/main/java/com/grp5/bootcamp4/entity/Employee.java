package com.grp5.bootcamp4.entity;




import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class Employee {
	
	
	@Id
    private long id;
	
	@NotBlank(message="Must enter a First Name")
    private String firstName;
	@NotBlank(message="Must enter an Last Name")
    private String lastName;
	@NotBlank(message="Must enter an emailID")
    private String emailId;
	@NotBlank(message="Must enter a Department")
    private String department;
	@NotBlank(message="Must enter a Designation")
    private String desiganation;
	@NotNull(message="Must enter a Date of Joining")
    private Date doj;
	@NotNull(message="Must enter a Date of Birth")
    private Date dob;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "id")
//	private User user;

    public Employee() {
    	
    }

    public Employee(long id, String firstName, String lastName, String emailId,String department,String desiganation, Date doj, Date dob) {
        this.id = id;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.department=department;
        this.desiganation=desiganation;
        this.doj=doj;
        this.dob=dob;
    }

    @Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
    	
    	 this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Column(name="deparment",nullable=false)
    public String getdeparment()
    {
    	return department;
    
   }
    public void setdeparment(String deparment) {
    	this.department=deparment;
    }
    
    @Column(name="designation",nullable=false)
    public String getdesignation()
    {
    	return desiganation;
    
   }
    public void setdesignation(String designation) {
    	this.desiganation=designation;
    }
    @Column(name="doj",nullable=false)
    public Date getdoj()
    {
    	return doj;
    
   }
    public void setdoj(Date doj) {
    	this.doj=doj;
    }
    @Column(name="dob",nullable=false)
    public Date getdob()
    {
    	return dob;
    
   }
    public void setdob(Date dob) {
    	this.dob=dob;
    }
    
//    public User getUser() {
//    	return user;
//    }
//    
//    public void setUser(User user) {
//    	this.user = user;
//    }
  
    
}
