package com.easylearn;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();
		
		List<Object[]> empList = session.createSQLQuery("SELECT id,first_name,last_name FROM EMPLOYEE").list();
		for (Object[] employee : empList) {
			System.out.println(Arrays.toString(employee));
		}

		List<Employee> empsList = session.createSQLQuery("SELECT * FROM EMPLOYEE")
				.addEntity(Employee.class)
				.list();
		for (Employee emp : empsList) {
			System.out.println(emp);
		}

	}
}
