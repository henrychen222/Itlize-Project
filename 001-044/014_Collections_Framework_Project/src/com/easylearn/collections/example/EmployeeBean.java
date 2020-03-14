package com.easylearn.collections.example;

import java.util.Comparator;

public class EmployeeBean implements Comparator<EmployeeBean>
{

	private Integer empId;
	private String empName;
	private Long ssnId;
	private Double salary;

	public EmployeeBean() {
	}

	public EmployeeBean(Integer empId, String empName, Long ssnId, Double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.ssnId = ssnId;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setSsnId(Long ssnId) {
		this.ssnId = ssnId;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getSsnId() {
		return ssnId;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", ssnId=" + ssnId + ", salary=" + salary
				+ "]";
	}

	@Override
	public int compare(EmployeeBean e1, EmployeeBean e2) {
		/*if (e1.getEmpId() > e2.getEmpId()) {
			return 1;
		} else if (e1.getEmpId() < e2.getEmpId()) {
			return -1;
		} else {
			return 0;
		}*/
		
		return e1.getEmpName().compareTo(e2.getEmpName());
	}

	/*@Override
	public int compareTo(EmployeeBean o) {

		if (this.getEmpId() > o.getEmpId()) {
			return -1;
		} else if (this.getEmpId() < o.getEmpId()) {
			return 1;
		} else {
			return 0;
		}

	}
*/
/*	@Override
	public int compare(EmployeeBean o1, EmployeeBean o2) {
		if (o1.getEmpId() > o2.getEmpId()) {
			return 1;
		} else if (o1.getEmpId() < o2.getEmpId()) {
			return -1;
		} else {
			return 0;
		}
	}
	*/
	
	
	
	
	
	
	
	

	/*@Override
	public int compareTo(Object o) {
		EmployeeBean em = (EmployeeBean) o;
		return this.getEmpName().compareTo(em.getEmpName());
	}
*/


}