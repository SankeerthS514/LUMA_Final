package com.grp5.bootcamp4.entity;

import jakarta.persistence.CascadeType;
import com.grp5.bootcamp4.service.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class User {
	
	@Id
    private long id;
    private String password;
    private String firstName;
    private String lastName;
    
//    @OneToOne
//    @JoinColumn(name="id")
//    @MapsId
//    private Employee employee;

    public User() {
    	
    }

    public User(long id, String password,String firstName, String lastName) {
    	this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName=lastName;

        
    }

    @Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
   

    @Column(name = "password", nullable = false)
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
    	
    	 this.password = password;
    }

    @Column(name = "First Name", nullable = false)
    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "Last Name", nullable = false)
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    
}

