package com.easylearn;
// Generated May 6, 2016 4:30:40 AM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person generated by hbm2java
 */
@Entity
//@Table(name = "person", catalog = "java_weekend_batch1")
@DiscriminatorValue(value="E")
public class Employee extends Person{

	private Date joiningDate;
	private String departmentName;

	public Employee() {
	}
	
	public Employee(String firstname, String lastname, String departmentName, Date joiningDate) {
		super(firstname, lastname);
		this.joiningDate = joiningDate;
		this.departmentName = departmentName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date", length = 0)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Column(name = "department_name", length = 50)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
