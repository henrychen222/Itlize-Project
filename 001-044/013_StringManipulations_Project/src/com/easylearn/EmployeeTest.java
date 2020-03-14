package com.easylearn;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee emp = new Employee("123456789");
		System.out.println(emp.hashCode());
		System.out.println(emp.getSocialSecurityNumber());

		emp = new Employee("987654321");
		System.out.println(emp.getSocialSecurityNumber());
		System.out.println(emp.hashCode());

	}

}
