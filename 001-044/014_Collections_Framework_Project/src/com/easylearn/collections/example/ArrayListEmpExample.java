package com.easylearn.collections.example;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEmpExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<EmployeeBean> empList = new ArrayList<EmployeeBean>();
		
		EmployeeBean emp2 = new EmployeeBean(new Integer(102), "Meghanath", new Long(123457), new Double(5896.56));
		empList.add(emp2);

		EmployeeBean emp4 = new EmployeeBean(new Integer(104), "Imitaz", new Long(123452), new Double(5896.56));
		empList.add(emp4);

		EmployeeBean emp3 = new EmployeeBean(new Integer(103), "Vicky", new Long(123458), new Double(5896.56));
		empList.add(emp3);

		EmployeeBean emp1 = new EmployeeBean(new Integer(101), "Bob", new Long(123456), new Double(5896.56));
		empList.add(emp1);

		EmployeeBean emp5 = new EmployeeBean(new Integer(105), "Tommy", new Long(123455), new Double(5896.56));
		empList.add(emp5);
		
		Collections.sort(empList, new EmployeeBean());
		
		for (EmployeeBean bean : empList) {
			System.out.println(bean);
		}

	}

}
