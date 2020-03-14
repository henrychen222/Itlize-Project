
// POJO - Plan Old Java Object  (OR) Java Beans
public class Employee {

	// Data Abstraction
	private int empId = 10232;
	private String empName;
	private String address;
	private double salary;
	private double noOfYearsExp;

	// Data Encapsulation
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getNoOfYearsExp() {
		return noOfYearsExp;
	}

	public void setNoOfYearsExp(double noOfYearsExp) {
		this.noOfYearsExp = noOfYearsExp;
	}

}
