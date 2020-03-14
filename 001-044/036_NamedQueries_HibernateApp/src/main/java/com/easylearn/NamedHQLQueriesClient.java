package com.easylearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * HQL
 */
public class NamedHQLQueriesClient {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("**************** HQL :  from query *********************");
		List<Employee> empList = session.getNamedQuery("getAllEmps").list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		
		System.out.println("**************** HQL :  from query *********************");
		empList = session.getNamedQuery("getAllEmps").list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		
		
		System.out.println("**************** HQL :  where query *********************");
		empList = session.getNamedQuery("filterEmps")
				.setParameter("amSalary_parm", new Double(15000))
				.list();
		for (Employee emp1 : empList) {
			System.out.println(emp1);
		}
		

	}
}
