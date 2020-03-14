package com.easylearn;

public class EmployeeBean {

	private String name;
	private Float salary;
	private Long empId;
	private Boolean isActive;
	private String department;
	private Address resiAddress;
	private Address mailAddress;

	public void setName(String name) {
		System.out.println("EmployeeBean : Setter injection is performed......");
		this.name = name;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setResiAddress(Address resiAddress) {
		this.resiAddress = resiAddress;
	}

	public void setMailAddress(Address mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Override
	public String toString() {
		return "EmployeeBean [name=" + name + ", salary=" + salary + ", empId=" + empId + ", isActive=" + isActive
				+ ", department=" + department + ",\n resiAddress=" + resiAddress + ",\n mailAddress=" + mailAddress + "]";
	}

}
