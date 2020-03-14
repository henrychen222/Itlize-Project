
public class EmpTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
	/*	emp.empId = 101;
		emp.address = "USA";
		emp.empName = "John";
		emp.noOfYearsExp = 6.7f;
		emp.salary = 6000.896;*/
		
		emp.setEmpId(101);
		System.out.println("empId = "+emp.getEmpId());

	}

}
