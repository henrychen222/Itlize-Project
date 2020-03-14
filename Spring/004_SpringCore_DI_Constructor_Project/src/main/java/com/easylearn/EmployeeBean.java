package com.easylearn;

public class EmployeeBean {

	private String name;
	private Float salary;
	private Long empId;
	private Boolean isActive;
	private String department;

	public EmployeeBean(String name, Float salary, Long empId, Boolean isActive, String department) {
		System.out.println("Constructor injection is performed...");
		this.name = name;
		this.salary = salary;
		this.empId = empId;
		this.isActive = isActive;
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeBean [name=" + name + ", salary=" + salary + ", empId=" + empId + ", isActive=" + isActive
				+ ", department=" + department + "]";
	}

}
