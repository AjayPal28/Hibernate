package com.ajay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
public class Regular_Employee extends Employee {
	@Column(name="salary")    
	private float salary;  
	  
	@Column(name="bonus")     
	private int bonus;  
}
