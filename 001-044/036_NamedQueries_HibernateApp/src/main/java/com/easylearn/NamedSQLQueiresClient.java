package com.easylearn;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class NamedSQLQueiresClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		
		List<Employee> empList = session.getNamedQuery("getNativeAllEmps").list();
		for (Employee employee : empList) {
			System.out.println(employee);
		}

		List<Employee> empsList = session.getNamedQuery("filterNativeEmps")
				.setParameter("amSalary_parm", new Double(15000))
				///.addEntity(Employee.class)
				.list();
		for (Employee emp : empsList) {
			System.out.println(emp);
		}

	}
}
