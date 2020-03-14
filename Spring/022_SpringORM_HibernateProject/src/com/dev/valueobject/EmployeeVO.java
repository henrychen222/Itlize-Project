package com.dev.valueobject;

import java.util.ArrayList;

import com.dev.db.Employee;

public class EmployeeVO {

	ArrayList<Employee> empList;
	int empTotCount;

	public ArrayList<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}

	public int getEmpTotCount() {
		return empTotCount;
	}

	public void setEmpTotCount(int empTotCount) {
		this.empTotCount = empTotCount;
	}

}
